package com.example.giupokedex.presentation.ui.activities

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.provider.Settings
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.giupokedex.R
import com.example.giupokedex.common.di.DIPokedexManager
import com.example.giupokedex.common.keys.HomeActivityKeys
import com.example.giupokedex.common.utils.GiuPokedexUtils
import com.example.giupokedex.common.utils.GiuPokedexUtils.enableDisableView
import com.example.giupokedex.common.utils.GiuPokedexUtils.hide
import com.example.giupokedex.common.utils.GiuPokedexUtils.show
import com.example.giupokedex.common.utils.ListenerEvents
import com.example.giupokedex.common.utils.PokedexSuggestionProvider
import com.example.giupokedex.databinding.ActivityHomeBinding
import com.example.giupokedex.presentation.ui.fragments.FavoriteFragmentDirections
import com.example.giupokedex.presentation.ui.fragments.HomeFragmentDirections
import com.example.giupokedex.presentation.ui.fragments.PokemonDetailFragmentDirections
import com.example.giupokedex.presentation.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class HomeActivity : AppCompatActivity(), ListenerEvents, Toolbar.OnMenuItemClickListener,
    SearchManager.OnDismissListener {
    private lateinit var sharedPreferencesGlobal: SharedPreferences
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
        sharedPreferencesGlobal = getSharedPreferences(
            getString(R.string.PREF_APP_NAME),
            Context.MODE_PRIVATE
        )

        verifyDevice()

        initDependencies(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        GiuPokedexUtils.setGlobalActivity(this)

        initNavHostFragment()
        initListeners()
        handleIntent(intent)
    }

    @SuppressLint("HardwareIds")
    private fun verifyDevice() {
        val deviceIdStr = resources.getString(R.string.PREF_DEVICE_ID)
        //first time installing the app on this device, clear the recent search suggestions
        if (sharedPreferencesGlobal.getString(deviceIdStr, null).isNullOrEmpty()) {
            SearchRecentSuggestions(
                this,
                PokedexSuggestionProvider.AUTHORITY,
                PokedexSuggestionProvider.MODE
            ).clearHistory()

            sharedPreferencesGlobal.edit().putString(
                deviceIdStr,
                Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            ).apply()
        }
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
//        showHideTopBarBackButton(false)
//        viewBinding.topAppBar.navigationIcon?.setVisible(false, true)
        viewBinding.topAppBar.setNavigationOnClickListener {
            if (lastFragment != HomeActivityKeys.HomeFragment.toString()) {
                enableIcon(0)
                //viewBinding.topAppBar.setNavigationIcon(R.drawable.baseline_home_black_24)
                doTransaction(HomeActivityKeys.HomeFragment.toString())
//                lastFragment = HomeActivityKeys.HomeFragment.toString()
//                replaceFragment(R.id.fragmentHome)
            }
        }
        viewBinding.topAppBar.setOnMenuItemClickListener(this)

/*        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if ( destination.id == R.id.fragmentFavorite) {
                showHideTopBarBackButton(true)
            } else {
                showHideTopBarBackButton(false)
            }
        }*/
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        item?.let { menuItem ->
            return when (menuItem.itemId) {
                R.id.search -> {
                    enableIcon(R.id.search)
                    onSearchRequested()

                    true
                }

                R.id.favorite -> {
//                    Toast.makeText(this, "favorite clicked", Toast.LENGTH_SHORT).show()
                    doTransaction(nextFragment = HomeActivityKeys.FavoriteFragment.toString())
//                    val checker = checkFragment(
//                        HomeActivityKeys.FavoriteFragment.toString(),
//                        lastFragment
//                    )
//
//                    if (!checker) {
//                        enableIcon(R.id.favorite)
//
//                        if (checkFragment(HomeActivityKeys.HomeFragment.toString(),lastFragment)) {
//
//                        }
//
//                        lastFragment = HomeActivityKeys.FavoriteFragment.toString()
//                        replaceFragment(R.id.fragmentFavorite)
//                    }

                    true
                }

                else -> {
                    false
                }
            }
        }

        return true
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

    private fun addQueryToRecentListAndSearch(query: String) {
        //add the query to the recent query list
        val queryLower = query.lowercase(Locale.getDefault())

        SearchRecentSuggestions(
            this,
            PokedexSuggestionProvider.AUTHORITY,
            PokedexSuggestionProvider.MODE
        ).saveRecentQuery(queryLower, null)

        doTransaction(HomeActivityKeys.PokemonDetailFragment.toString(), queryLower)

//        val checker = checkFragment(
//            HomeActivityKeys.PokemonDetailFragment.toString(),
//            lastFragment
//        )
//
//        if (!checker) {
//            lastFragment = HomeActivityKeys.PokemonDetailFragment.toString()
//            replaceFragment(R.id.fragmentPokemonDetail)
//        }

//        searchPokemon(queryLower)
    }

    fun searchPokemon(query: String) {
        showHideProgressBar(true)
        homeViewModel.searchPokemon(query)
    }

    fun getListPokemons(page: Int) {
        homeViewModel.getListPokemon(page)
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
                navGraph.setStartDestination(fragmentID)
                navController.graph = navGraph
            }.commit()
    }

    private fun doTransaction(nextFragment: String, query: String = "") {
        when (lastFragment) {
            HomeActivityKeys.HomeFragment.toString() -> {
                if (nextFragment == HomeActivityKeys.PokemonDetailFragment.toString()) {
                    findNavController(R.id.pokedex_nav_host).navigate(
                        HomeFragmentDirections.actionFragmentHomeToPokemonDetailFragment(query)
                    )
                } else if (nextFragment == HomeActivityKeys.FavoriteFragment.toString()) {
                    findNavController(R.id.pokedex_nav_host).navigate(
                        HomeFragmentDirections.actionFragmentHomeToFavoriteFragment()
                    )
                }
            }

            HomeActivityKeys.PokemonDetailFragment.toString() -> {
                if (nextFragment == HomeActivityKeys.HomeFragment.toString()) {
                    findNavController(R.id.pokedex_nav_host).navigate(
                        PokemonDetailFragmentDirections.actionFragmentPokemonDetailToHomeFragment()
                    )
                } else if (nextFragment == HomeActivityKeys.FavoriteFragment.toString()) {
                    findNavController(R.id.pokedex_nav_host).navigate(
                        PokemonDetailFragmentDirections.actionFragmentPokemonDetailToFavoriteFragment()
                    )
                }
            }

            HomeActivityKeys.FavoriteFragment.toString() -> {
                if (nextFragment == HomeActivityKeys.HomeFragment.toString()) {
                    findNavController(R.id.pokedex_nav_host).navigate(
                        FavoriteFragmentDirections.actionFragmentFavoriteToHomeFragment()
                    )
                } else if (nextFragment == HomeActivityKeys.PokemonDetailFragment.toString()) {
                    findNavController(R.id.pokedex_nav_host).navigate(
                        FavoriteFragmentDirections.actionFragmentFavoriteToPokemonDetailFragment(query)
                    )
                }
            }
        }
    }

    private fun enableIcon(iconId: Int = 0, isDetail: Boolean = false) {
        //set icon enable (selected) or disable (unselected)
        if (isDetail) {
            viewBinding.topAppBar.apply {
                setNavigationIcon(R.drawable.baseline_home_white_24)
                menu.findItem(R.id.favorite).setIcon(R.drawable.baseline_favorite_white_24)
            }
        } else {
            when (iconId) {
                R.id.favorite -> {
                    viewBinding.topAppBar.apply {
                        setNavigationIcon(R.drawable.baseline_home_white_24)
                        menu.findItem(iconId).setIcon(R.drawable.baseline_favorite_black_24)
                    }
                }
                R.id.search -> {
                    viewBinding.topAppBar.apply {
                        setNavigationIcon(R.drawable.baseline_home_white_24)
                        menu.findItem(R.id.favorite).setIcon(R.drawable.baseline_favorite_white_24)
                    }
                }
                else -> {
                    viewBinding.topAppBar.apply {
                        setNavigationIcon(R.drawable.baseline_home_black_24)
                        menu.findItem(R.id.favorite).setIcon(R.drawable.baseline_favorite_white_24)
                    }
                }
            }
        }
    }

    fun showHideProgressBar(visibility: Boolean) {
        if (visibility) {
            viewBinding.progressBar.show()
            viewBinding.activityContent.alpha = 0.2f
            enableDisableView(this, false)
        } else {
            viewBinding.progressBar.hide()
            viewBinding.activityContent.alpha = 1f
            enableDisableView(this, true)
        }
    }

    fun getAbilityDetail(abilityId: String) {
        showHideProgressBar(true)
        homeViewModel.searchAbilityDetail(abilityId)
    }
}