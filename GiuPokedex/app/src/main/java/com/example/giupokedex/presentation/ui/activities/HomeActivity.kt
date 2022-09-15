package com.example.giupokedex.presentation.ui.activities

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import com.example.giupokedex.R
import com.example.giupokedex.common.di.DIPokedexManager
import com.example.giupokedex.common.keys.HomeActivityKeys
import com.example.giupokedex.common.utils.ListenerEvents
import com.example.giupokedex.common.utils.PokedexSuggestionProvider
import com.example.giupokedex.common.utils.Screen
import com.example.giupokedex.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), ListenerEvents, Toolbar.OnMenuItemClickListener,
    SearchManager.OnDismissListener {
    private lateinit var sharedPreferencesGlobal: SharedPreferences
    private lateinit var viewBinding: ActivityHomeBinding

    //store the value of the last accessed fragment
    private var lastFragment = HomeActivityKeys.HomeFragment.toString()
    private lateinit var navHostFragment: NavHostFragment

    override fun onDismiss() {
        //TODO("Fazer algo se necessário quando o search dialog é fechado")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferencesGlobal = getSharedPreferences(
            getString(R.string.PREF_APP_NAME),
            Context.MODE_PRIVATE
        )

        initDependencies(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initNavHostFragment()
        initListeners()
        handleIntent(intent)
    }

    private fun initDependencies(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            DIPokedexManager().initPokedexDependencyInjection(application)
        }
    }

    private fun initNavHostFragment() {
        navHostFragment = supportFragmentManager.findFragmentById(
            R.id.pokedex_nav_host
        ) as NavHostFragment
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        // Verify the action and get the query
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                //add the query to the recent query list
                SearchRecentSuggestions(
                    this,
                    PokedexSuggestionProvider.AUTHORITY,
                    PokedexSuggestionProvider.MODE
                ).saveRecentQuery(query, null)

                /** se quiser limpar o histórico de sugestão:
                 *
                    SearchRecentSuggestions(this, PokedexSuggestionProvider.AUTHORITY, PokedexSuggestionProvider.MODE)
                        .clearHistory()
                 */

                searchPokemon(query)
            }
        }
    }

    private fun checkFragment(currentFragment: String, lastFragment: String): Boolean {
        return currentFragment == lastFragment
    }

    private fun replaceFragment(fragmentID: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                viewBinding.pokedexNavHost.id,
                navHostFragment,
                HomeActivityKeys.PokedexHostNav.toString()
            )
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .runOnCommit {
                val navController = navHostFragment.navController
                val navGraph = navController.navInflater.inflate(R.navigation.nav_pokedex)
                navGraph.startDestination = fragmentID
                navController.graph = navGraph
            }.commit()
    }

    override fun initListeners() {
        showHideTopBarBackButton(false)
        viewBinding.topAppBar.setOnMenuItemClickListener(this)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.fragmentHistory || destination.id == R.id.fragmentFavorite) {
                showHideTopBarBackButton(true)
            } else {
                showHideTopBarBackButton(false)
            }
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        item?.let { menuItem ->
            return when (menuItem.itemId) {
                R.id.search -> {
                    enableDisableIcon(R.id.search, true)
                    onSearchRequested()

                    true
                }

                R.id.favorite -> {
                    val checker = checkFragment(
                        HomeActivityKeys.FavoriteFragment.toString(),
                        lastFragment
                    )

                    if (!checker) {
                        enableDisableIcon(R.id.favorite, true)
                        enableDisableIcon(R.id.history, false)

                        lastFragment = HomeActivityKeys.FavoriteFragment.toString()
                        replaceFragment(R.id.fragmentFavorite)
                    }

                    true
                }

                R.id.history -> {
                    val checker = checkFragment(
                        HomeActivityKeys.HistoryFragment.toString(),
                        lastFragment
                    )

                    if (!checker) {
                        enableDisableIcon(R.id.history, true)
                        enableDisableIcon(R.id.favorite, false)

                        lastFragment = HomeActivityKeys.FavoriteFragment.toString()
                        replaceFragment(R.id.fragmentFavorite)
                    }

                    true
                }

                else -> {
                    false
                }
            }
        }

        return true
    }

    private fun enableDisableIcon(iconId: Int, isEnable: Boolean) {
        //set icon enable (selected) or disable (unselected)
        when (iconId) {
            R.id.favorite -> {
                if (isEnable) {
                    viewBinding.topAppBar.menu.findItem(iconId)
                        .setIcon(R.drawable.baseline_favorite_black_24)
                } else {
                    viewBinding.topAppBar.menu.findItem(iconId)
                        .setIcon(R.drawable.baseline_favorite_white_24)
                }
            }
            R.id.history -> {
                if (isEnable) {
                    viewBinding.topAppBar.menu.findItem(iconId)
                        .setIcon(R.drawable.baseline_history_black_24)
                } else {
                    viewBinding.topAppBar.menu.findItem(iconId)
                        .setIcon(R.drawable.baseline_history_white_24)
                }
            }
            else -> {
                viewBinding.topAppBar.menu.findItem(iconId)
                    .setIcon(R.drawable.baseline_favorite_white_24)

                viewBinding.topAppBar.menu.findItem(iconId)
                    .setIcon(R.drawable.baseline_history_white_24)
            }
        }
    }

    private fun showHideTopBarBackButton(shouldShow: Boolean) {
        if (shouldShow) {
            viewBinding.topAppBar.navigationIcon?.setVisible(true, false)
        } else viewBinding.topAppBar.navigationIcon?.setVisible(false, false)
    }

    fun showHideProgressBar(visibility: Boolean) {
        if (visibility) {
            viewBinding.progressBar.visibility = View.VISIBLE
            viewBinding.activityContent.alpha = 0.2f
            Screen.enableDisableView(this, false)
        } else {
            viewBinding.progressBar.visibility = View.GONE
            viewBinding.activityContent.alpha = 1f
            Screen.enableDisableView(this, true)
        }
    }

    private fun searchPokemon(idOrName: String) {
        //TODO("implementar")
    }
}