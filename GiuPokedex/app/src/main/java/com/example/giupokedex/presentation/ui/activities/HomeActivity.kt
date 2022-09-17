package com.example.giupokedex.presentation.ui.activities

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.navigation.fragment.NavHostFragment
import com.example.giupokedex.R
import com.example.giupokedex.common.di.DIPokedexManager
import com.example.giupokedex.common.keys.HomeActivityKeys
import com.example.giupokedex.common.utils.GiuPokedexUtils
import com.example.giupokedex.common.utils.GiuPokedexUtils.enableDisableView
import com.example.giupokedex.common.utils.ListenerEvents
import com.example.giupokedex.common.utils.PokedexSuggestionProvider
import com.example.giupokedex.databinding.ActivityHomeBinding
import com.example.giupokedex.presentation.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(), ListenerEvents, Toolbar.OnMenuItemClickListener,
    SearchManager.OnDismissListener {
    //    private lateinit var sharedPreferencesGlobal: SharedPreferences
    private lateinit var viewBinding: ActivityHomeBinding

    //store the value of the last accessed fragment
    private var lastFragment = HomeActivityKeys.HomeFragment.toString()
    private lateinit var navHostFragment: NavHostFragment

    val homeViewModel: HomeViewModel by viewModel()

    override fun onDismiss() {
        //TODO("Fazer algo se necessário quando o search dialog é fechado")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        sharedPreferencesGlobal = getSharedPreferences(
//            getString(R.string.PREF_APP_NAME),
//            Context.MODE_PRIVATE
//        )

        initDependencies(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        GiuPokedexUtils.setGlobalActivity(this)

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

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        // Verify the action and get the query
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                addQueryToRecentListAndSearch(query)
            }
        }
    }

    fun addQueryToRecentListAndSearch(query: String) {
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

    private fun searchPokemon(query: String) {
        showHideProgressBar(true)
        homeViewModel.searchPokemon(query)
        //homeViewModel.searchGlitchPokemon(query)
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
            .setTransition(TRANSIT_FRAGMENT_FADE)
            .runOnCommit {
                val navController = navHostFragment.navController
                val navGraph = navController.navInflater.inflate(R.navigation.nav_pokedex)
                navGraph.startDestination = fragmentID
                navController.graph = navGraph
            }.commit()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        item?.let { menuItem ->
            return when (menuItem.itemId) {
                R.id.search -> {
                    Toast.makeText(this, "search clicked", Toast.LENGTH_SHORT).show()
                    enableIcon(R.id.search)
                    onSearchRequested()

                    true
                }

                R.id.favorite -> {
                    Toast.makeText(this, "favorite clicked", Toast.LENGTH_SHORT).show()
                    val checker = checkFragment(
                        HomeActivityKeys.FavoriteFragment.toString(),
                        lastFragment
                    )

                    if (!checker) {
                        enableIcon(R.id.favorite)

                        lastFragment = HomeActivityKeys.FavoriteFragment.toString()
                        replaceFragment(R.id.fragmentFavorite)
                    }

                    true
                }

                R.id.history -> {
                    Toast.makeText(this, "history clicked", Toast.LENGTH_SHORT).show()
                    val checker = checkFragment(
                        HomeActivityKeys.HistoryFragment.toString(),
                        lastFragment
                    )

                    if (!checker) {
                        enableIcon(R.id.history)

                        lastFragment = HomeActivityKeys.FavoriteFragment.toString()
                        replaceFragment(R.id.fragmentFavorite)
                    }

                    true
                }

                else -> {
                    Toast.makeText(this, "else menuclicklistener", Toast.LENGTH_SHORT).show()
                    false
                }
            }
        }

        return true
    }

    private fun enableIcon(iconId: Int) {
        //set icon enable (selected) or disable (unselected)
        when (iconId) {
            R.id.favorite -> {
                viewBinding.topAppBar.menu.findItem(iconId)
                    .setIcon(R.drawable.baseline_favorite_black_24)

                viewBinding.topAppBar.menu.findItem(R.id.history)
                    .setIcon(R.drawable.baseline_history_white_24)
            }
            R.id.history -> {
                viewBinding.topAppBar.menu.findItem(iconId)
                    .setIcon(R.drawable.baseline_history_black_24)

                viewBinding.topAppBar.menu.findItem(R.id.favorite)
                    .setIcon(R.drawable.baseline_favorite_white_24)
            }
            else -> {
                viewBinding.topAppBar.menu.findItem(R.id.favorite)
                    .setIcon(R.drawable.baseline_favorite_white_24)

                viewBinding.topAppBar.menu.findItem(R.id.history)
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
            enableDisableView(this, false)
        } else {
            viewBinding.progressBar.visibility = View.GONE
            viewBinding.activityContent.alpha = 1f
            enableDisableView(this, true)
        }
    }
}