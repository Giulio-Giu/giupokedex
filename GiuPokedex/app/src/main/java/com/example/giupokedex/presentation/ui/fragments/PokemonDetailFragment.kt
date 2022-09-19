package com.example.giupokedex.presentation.ui.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.giupokedex.R
import com.example.giupokedex.common.keys.HomeActivityKeys
import com.example.giupokedex.common.utils.GiuPokedexUtils.getTextInitialCap
import com.example.giupokedex.common.utils.GiuPokedexUtils.getTypeColorOrId
import com.example.giupokedex.common.utils.GiuPokedexUtils.hide
import com.example.giupokedex.common.utils.GiuPokedexUtils.show
import com.example.giupokedex.common.utils.ListenerEvents
import com.example.giupokedex.common.utils.ObservableEvents
import com.example.giupokedex.databinding.FragmentPokemonDetailBinding
import com.example.giupokedex.domain.models.FullPokemon
import com.example.giupokedex.domain.models.pokeapi_co.base.Ability
import com.example.giupokedex.domain.models.pokeapi_co.base.Type
import com.example.giupokedex.domain.models.pokeapi_co.detail.AbilityDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.TypeDetail
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.Pokemon
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon
import com.example.giupokedex.presentation.eventclick.EventClickItemPokemonAbility
import com.example.giupokedex.presentation.eventclick.EventClickItemPokemonType
import com.example.giupokedex.presentation.ui.activities.HomeActivity
import com.example.giupokedex.presentation.ui.adapters.PokemonAbilitiesAdapter
import com.example.giupokedex.presentation.ui.adapters.PokemonPicturesAdapter
import com.example.giupokedex.presentation.ui.adapters.PokemonTypesAdapter
import com.example.giupokedex.presentation.ui.adapters.TypePokemonsAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textview.MaterialTextView

class PokemonDetailFragment : Fragment(), ObservableEvents, ListenerEvents {
    private lateinit var query: String
    private val args: PokemonDetailFragmentArgs by navArgs()

    private var shouldShowAbilityDescription = false
    private var shouldShowTypeListPokemons = false

    private var _binding: FragmentPokemonDetailBinding? = null
    private val viewBinding get() = _binding!!

    lateinit var homeActivity: HomeActivity

    private var _pokemon: Pokemon = Pokemon()
    private var _glitchPokemon: GlitchPokemon = GlitchPokemon()
    private var _fullPokemon: FullPokemon = FullPokemon()

    private var picturesAdapter = PokemonPicturesAdapter(arrayListOf())
    private var typesAdapter = PokemonTypesAdapter(arrayListOf())
    private var abilitiesAdapter = PokemonAbilitiesAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivity = (activity as HomeActivity)
        query = args.pokemonNumber

        if (query.trim().isNotEmpty()) homeActivity.searchPokemon(query)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(getString(R.string.FULL_POKEMON), _fullPokemon)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        val pokemonState =
            savedInstanceState?.getParcelable(getString(R.string.FULL_POKEMON)) as FullPokemon?

        pokemonState?.let {
            _fullPokemon = it
            fillPokemonStats()
        }

        super.onViewStateRestored(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservables()
        initListeners()
    }

    override fun onDestroyView() {
        homeActivity.homeViewModel.dontShowTypeListPokemon()
        homeActivity.homeViewModel.dontShowAbilityDescription()
        homeActivity.lastFragment = HomeActivityKeys.HomeFragment.toString()
        _binding = null
        super.onDestroyView()
    }

    private fun initView() {
        viewBinding.constraintData.hide()
        viewBinding.groupNoData.hide()
        homeActivity.showHideProgressBar(true)
        setUpAdapters()
    }

    override fun initObservables() {
        homeActivity.homeViewModel.getFullPokemonDataMediatorLiveData.observe(
            viewLifecycleOwner
        ) { verifyResponse(it) }

        homeActivity.homeViewModel.getTypeDetailLiveData.observe(
            viewLifecycleOwner
        ) { showTypeInfo(it) }

        homeActivity.homeViewModel.getAbilityDetailLiveData.observe(
            viewLifecycleOwner
        ) { showAbilityInfo(it) }

        homeActivity.homeViewModel.shouldShowTypeListPokemon.observe(
            viewLifecycleOwner
        ) { shouldShowTypeListPokemons = it }

        homeActivity.homeViewModel.shouldShowAbilityDescription.observe(
            viewLifecycleOwner
        ) { shouldShowAbilityDescription = it }
    }

    override fun initListeners() {
        typesAdapter.eventClickItemPokemonType = object : EventClickItemPokemonType {
            override fun onClickItemPokemonType(type: Type) {
                homeActivity.getTypeDetail(type.getTypeId())
            }
        }

        abilitiesAdapter.eventClickItemPokemonAbility = object : EventClickItemPokemonAbility {
            override fun onClickItemPokemonAbility(ability: Ability) {
                homeActivity.getAbilityDetail(ability.getAbilityId())
            }
        }
    }

    private fun showTypeInfo(type: TypeDetail) {
        if (shouldShowTypeListPokemons) {
            val customDialog = Dialog(requireContext())
            customDialog.setContentView(R.layout.custom_dialog_type_pokemons)

            val dialogTextViewTitle: MaterialTextView =
                customDialog.findViewById(R.id.cd_type_pokemon_title)
            dialogTextViewTitle.text = resources.getString(
                R.string.custom_dialog_type_pokemon_title,
                type.name.getTextInitialCap()
            )

            val dialogRecycler: RecyclerView =
                customDialog.findViewById(R.id.recycler_cd_type_pokemon)
            val dialogAdapter = TypePokemonsAdapter(type.name, type.getTypePokemonsList())
            dialogRecycler.adapter = dialogAdapter

            val dialogButton: MaterialButton =
                customDialog.findViewById(R.id.cd_type_pokemon_btn_ok)
            dialogButton.setOnClickListener {
                customDialog.dismiss()
            }

            homeActivity.showHideProgressBar(false)
            customDialog.show()
        }
    }

    private fun showAbilityInfo(ability: AbilityDetail) {
        homeActivity.showHideProgressBar(false)

        if (shouldShowAbilityDescription) {
            MaterialAlertDialogBuilder(viewBinding.root.context)
                .setTitle(ability.name)
                .setMessage(ability.getAbilityEffect().effect)
                .setPositiveButton(resources.getString(R.string.btn_ok)) { dialog, _ ->
                    dialog.dismiss()
                    dialog.cancel()
                }
                .show()
        }
    }

    private fun verifyResponse(pair: Pair<Pokemon?, GlitchPokemon?>) {
        pair.first?.let { first ->
            pair.second?.let { second ->
                fillPokemon(first)
                fillGlitchPokemon(second)
                verifyData()
            }
        }
    }

    private fun fillPokemon(pokemon: Pokemon) {
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
    }

    private fun fillGlitchPokemon(glitchPokemon: GlitchPokemon) {
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
            pokemonNumber.text = _fullPokemon.getNumberString()

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
            pokemonHeightValue.text = _fullPokemon.getHeightString()
            pokemonWeightValue.text = _fullPokemon.getWeightString()

            if (_fullPokemon.is_starter) pokemonStarter.show() else pokemonStarter.hide()
            if (_fullPokemon.is_legendary) pokemonLegendary.show() else pokemonLegendary.hide()
            if (_fullPokemon.is_mythical) pokemonMythical.show() else pokemonMythical.hide()
            if (_fullPokemon.is_ultraBeast) pokemonUltraBeast.show() else pokemonUltraBeast.hide()
            if (_fullPokemon.is_mega) pokemonMega.show() else pokemonMega.hide()

            pokemonDescription.text = _fullPokemon.description
            picturesAdapter.updateList(_fullPokemon.sprites.getImagesArrayList())
            typesAdapter.updateList(ArrayList(_fullPokemon.getPokemonTypesList()))
            abilitiesAdapter.updateList(ArrayList(_fullPokemon.getPokemonAbilitiesList()))

            fillPokemonStats()
        }
    }

    private fun fillPokemonStats() {
        viewBinding.apply {
            pokemonStatsHpValue.progress = _fullPokemon.hp.toFloat()
            pokemonStatsHpValue.labelText = _fullPokemon.getHpString()

            pokemonStatsAttackValue.progress = _fullPokemon.attack.toFloat()
            pokemonStatsAttackValue.labelText = _fullPokemon.getAttackString()

            pokemonStatsDefenseValue.progress = _fullPokemon.defense.toFloat()
            pokemonStatsDefenseValue.labelText = _fullPokemon.getDefenseString()

            pokemonStatsSpecialAttackValue.progress = _fullPokemon.special_attack.toFloat()
            pokemonStatsSpecialAttackValue.labelText = _fullPokemon.getSpecialAttackString()

            pokemonStatsSpecialDefenseValue.progress = _fullPokemon.special_defense.toFloat()
            pokemonStatsSpecialDefenseValue.labelText = _fullPokemon.getSpecialDefenseString()

            pokemonStatsSpeedValue.progress = _fullPokemon.speed.toFloat()
            pokemonStatsSpeedValue.labelText = _fullPokemon.getSpeedString()

            pokemonStatsExpValue.progress = _fullPokemon.exp.toFloat()
            pokemonStatsExpValue.labelText = _fullPokemon.getExpString()
        }
    }

    private fun showNoDataContent() {
        viewBinding.constraintData.hide()
        viewBinding.groupNoData.show()
        homeActivity.showHideProgressBar(false)
    }

    private fun setUpAdapters() {
        viewBinding.recyclerViewPokemonPictures.adapter = picturesAdapter
        viewBinding.recyclerViewPokemonTypes.adapter = typesAdapter
        viewBinding.recyclerViewPokemonAbilities.adapter = abilitiesAdapter
    }
}