package com.example.giupokedex.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.load
import com.example.giupokedex.R
import com.example.giupokedex.common.utils.GiuPokedexUtils.hide
import com.example.giupokedex.common.utils.GiuPokedexUtils.show
import com.example.giupokedex.common.utils.ListenerEvents
import com.example.giupokedex.common.utils.ObservableEvents
import com.example.giupokedex.databinding.FragmentHomeBinding
import com.example.giupokedex.domain.models.FullPokemon
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.Pokemon
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon
import com.example.giupokedex.presentation.ui.activities.HomeActivity
import kotlin.random.Random

class HomeFragment : Fragment(), ObservableEvents, ListenerEvents, View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val viewBinding get() = _binding!!

    lateinit var homeActivity: HomeActivity

    private var _pokemon: Pokemon = Pokemon()
    private var _glitchPokemon: GlitchPokemon = GlitchPokemon()
    private var _fullPokemon: FullPokemon = FullPokemon()
    private var hasSuccessfulApiGet = false

    //private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var randomGenerator: Random

    private fun randomNumber(): String {
        randomGenerator = Random(System.currentTimeMillis())
        val randInt = randomGenerator.nextInt(1, 700)
        Toast.makeText(homeActivity, "randInt: $randInt", Toast.LENGTH_SHORT).show()
        return randInt.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivity = (activity as HomeActivity)
        homeActivity.addQueryToRecentListAndSearch(randomNumber())

//        initObservables()
//
//        homeActivity.addQueryToRecentListAndSearch(randomNumber())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initObservables()
//        homeActivity.addQueryToRecentListAndSearch(randomNumber())
        initView()
        initObservables()
        initListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View) {
        when (view.id) {

        }
    }

    override fun initListeners() {
        //TODO(quando clicar para pesquisar, chamar: onSearchRequested()
    }

    override fun initObservables() {
        homeActivity.homeViewModel.getAllPokemonDataMediatorLiveData.observe(
            viewLifecycleOwner
        ) { verifyResponse(it) }
    }

    private fun verifyResponse(pair: Pair<Pokemon?, GlitchPokemon?>) {
        pair.first?.let { first ->
            pair.second?.let { second ->
                fillPokemon(first)
                fillGlitchPokemon(second)
//                completeFullPokemon()
                verifyData()
            }
        }
//        pair.second?.let { fillGlitchPokemon(it) }
//        hasSuccessfulApiGet = true
//        verifyData()
    }

    private fun fillPokemon(pokemon: Pokemon) {
//        hasSuccessfulApiGet = true

        _pokemon.apply {
            id = pokemon.id
            name = pokemon.name
            height = pokemon.height
            weight = pokemon.weight
            expStat = pokemon.expStat
            sprites = pokemon.sprites
            abilities = pokemon.abilities
            stats = pokemon.stats
            pokemonTypes = pokemon.pokemonTypes
        }

//        if (hasSuccessfulApiGet) {
//            verifyData()
//        }
    }

    private fun fillGlitchPokemon(glitchPokemon: GlitchPokemon) {
//        hasGlitchPokemonApiReturn = true

        _glitchPokemon.apply {
            number = glitchPokemon.number
            name = glitchPokemon.name
            species = glitchPokemon.species
            description = glitchPokemon.description
            family = glitchPokemon.family
            image = glitchPokemon.image
            is_starter = glitchPokemon.is_starter
            is_legendary = glitchPokemon.is_legendary
            is_mythical = glitchPokemon.is_mythical
            is_ultraBeast = glitchPokemon.is_ultraBeast
            is_mega = glitchPokemon.is_mega
        }
    }

    private fun verifyData() {
        if (_pokemon.id != 0) completeFullPokemon() else showNoDataContent()
    }

    private fun completeFullPokemon() {
        _fullPokemon.apply {
            number = _pokemon.id
            height = _pokemon.height
            weight = _pokemon.weight
            expStat = _pokemon.expStat
            name = _glitchPokemon.name
            species = _glitchPokemon.species
            description = _glitchPokemon.description
            image = _glitchPokemon.image
            family = _glitchPokemon.family
            sprites = _pokemon.sprites
            abilities = _pokemon.abilities
            stats = _pokemon.stats
            types = _pokemon.pokemonTypes
            is_starter = _glitchPokemon.is_starter
            is_legendary = _glitchPokemon.is_legendary
            is_mythical = _glitchPokemon.is_mythical
            is_ultraBeast = _glitchPokemon.is_ultraBeast
            is_mega = _glitchPokemon.is_mega
        }

        refreshLayout()
    }

    private fun refreshLayout() {
        homeActivity.showHideProgressBar(false)
        viewBinding.constraintData.show()
        viewBinding.groupNoData.hide()

        viewBinding.apply {
            pokemonName.text = _fullPokemon.name
            pokemonNumber.text = String.format("Nº #03d", _fullPokemon.number)/* homeActivity.getString(
                R.string.number_value,
                _fullPokemon.number.toString().padStart(3, '0')
            )*/

            val image = if (_fullPokemon.image.trim()
                    .isNotEmpty()
            ) _fullPokemon.image else _fullPokemon.sprites.front_default
            pokemonImage.load(image) {
                listener(
                    onSuccess = { _, _ ->
                        progressBarPokemonImage.hide()
                        pokemonImage.apply {
                            show()
                            scaleType = ImageView.ScaleType.CENTER_INSIDE
                        }
                    },
                    onError = { _, _ ->
                        progressBarPokemonImage.hide()
                        pokemonImage.apply {
                            show()
                            scaleType = ImageView.ScaleType.FIT_CENTER
                            setImageResource(R.drawable.ic_error_outline_24)
                        }
                    }
                )
            }

            pokemonSpecieValue.text = _fullPokemon.species
            pokemonHeightValue.text = String.format("%.1f kg", _fullPokemon.height.toFloat() / 10) //getCorrectValue(isHeight = true, _fullPokemon.height)
            pokemonWeightValue.text = String.format("%.1f m", _fullPokemon.weight.toFloat() / 10) //getCorrectValue(isHeight = false, _fullPokemon.weight)

            if (_fullPokemon.is_starter) pokemonStarter.show() else pokemonStarter.hide()
            if (_fullPokemon.is_legendary) pokemonLegendary.show() else pokemonLegendary.hide()
            if (_fullPokemon.is_mythical) pokemonMythical.show() else pokemonMythical.hide()
            if (_fullPokemon.is_ultraBeast) pokemonUltraBeast.show() else pokemonUltraBeast.hide()
            if (_fullPokemon.is_mega) pokemonMega.show() else pokemonMega.hide()

            pokemonDescription.text = _fullPokemon.description
            //TODO( array de imagens
            //TODO( array de tipos
            fillPokemonStats()
        }
    }

    private fun fillPokemonStats() {
        viewBinding.apply {
            pokemonStatsHpValue.progress = _fullPokemon.stats[0].baseValue.toFloat()
            pokemonStatsHpValue.labelText =
                getCorrectStatLabelText(_fullPokemon.stats[0].baseValue.toFloat(), "hp")

            pokemonStatsAttackValue.progress = _fullPokemon.stats[1].baseValue.toFloat()
            pokemonStatsAttackValue.labelText =
                getCorrectStatLabelText(_fullPokemon.stats[1].baseValue.toFloat(), "attack")

            pokemonStatsDefenseValue.progress = _fullPokemon.stats[2].baseValue.toFloat()
            pokemonStatsDefenseValue.labelText =
                getCorrectStatLabelText(_fullPokemon.stats[2].baseValue.toFloat(), "defense")

            pokemonStatsSpecialAttackValue.progress = _fullPokemon.stats[3].baseValue.toFloat()
            pokemonStatsSpecialAttackValue.labelText =
                getCorrectStatLabelText(_fullPokemon.stats[3].baseValue.toFloat(), "special_attack")

            pokemonStatsSpecialDefenseValue.progress = _fullPokemon.stats[4].baseValue.toFloat()
            pokemonStatsSpecialDefenseValue.labelText = getCorrectStatLabelText(
                _fullPokemon.stats[4].baseValue.toFloat(),
                "special_defense"
            )

            pokemonStatsSpeedValue.progress = _fullPokemon.stats[5].baseValue.toFloat()
            pokemonStatsSpeedValue.labelText =
                getCorrectStatLabelText(_fullPokemon.stats[5].baseValue.toFloat(), "speed")

            pokemonStatsExpValue.progress = _fullPokemon.expStat.toFloat()
            pokemonStatsExpValue.labelText =
                getCorrectStatLabelText(_fullPokemon.expStat.toFloat(), "exp")
        }
    }

    private fun getCorrectStatLabelText(baseValue: Float, currStat: String): String {
        val myResources = homeActivity.resources

        return when (currStat) {
            "hp" -> {
                "$baseValue/${myResources.getInteger(R.integer.stats_max_hp)}"
            }
            "attack" -> {
                "$baseValue/${myResources.getInteger(R.integer.stats_max_attack)}"
            }
            "defense" -> {
                "$baseValue/${myResources.getInteger(R.integer.stats_max_defense)}"
            }
            "special_attack" -> {
                "$baseValue/${myResources.getInteger(R.integer.stats_max_special_attack)}"
            }
            "special_defense" -> {
                "$baseValue/${myResources.getInteger(R.integer.stats_max_special_defense)}"
            }
            "speed" -> {
                "$baseValue/${myResources.getInteger(R.integer.stats_max_speed)}"
            }
            "exp" -> {
                "$baseValue/${myResources.getInteger(R.integer.stats_max_exp)}"
            }
            else -> ""
        }
    }

    private fun getCorrectValue(isHeight: Boolean, currValue: Int): String {
        val newValue = currValue.toDouble() / 10.toDouble()
        return if (isHeight) {
            "$newValue m"
        } else {
            "$newValue kg"
        }
    }

    private fun showNoDataContent() {
        viewBinding.constraintData.hide()
        viewBinding.groupNoData.show()
        homeActivity.showHideProgressBar(false)
    }

    private fun initView() {
        viewBinding.constraintData.hide()
        viewBinding.groupNoData.hide()
        homeActivity.showHideProgressBar(true)
        setUpAdapters()
    }

    private fun setUpAdapters() {

    }
}