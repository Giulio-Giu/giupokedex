package com.example.giupokedex.presentation.viewmodels

import androidx.lifecycle.*
import com.example.giupokedex.domain.models.pokeapi_co.ListPokemon
import com.example.giupokedex.domain.models.pokeapi_co.detail.AbilityDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.TypeDetail
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.Pokemon
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon
import com.example.giupokedex.domain.usecases.abs.PokedexUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val pokedexUseCase: PokedexUseCase
) : ViewModel() {
    /** Region LiveData */
    private val _getListPokemonMutableLiveData = MutableLiveData<ListPokemon>()
    val getListPokemonLiveData: LiveData<ListPokemon>
        get() = _getListPokemonMutableLiveData

    private val _getPokemonMutableLiveData = MutableLiveData<Pokemon>()
    private val _getGlitchPokemonMutableLiveData = MutableLiveData<GlitchPokemon>()

    val getFullPokemonDataMediatorLiveData =
        MediatorLiveData<Pair<Pokemon?, GlitchPokemon?>>().apply {
            addSource(_getPokemonMutableLiveData) {
                value = Pair(it, _getGlitchPokemonMutableLiveData.value)
            }
            addSource(_getGlitchPokemonMutableLiveData) {
                value = Pair(_getPokemonMutableLiveData.value, it)
            }
        }

    private val _shouldShowAbilityDescriptionMutableLiveData = MutableLiveData<Boolean>()
    val shouldShowAbilityDescription: LiveData<Boolean>
        get() = _shouldShowAbilityDescriptionMutableLiveData


    private val _shouldShowTypeListPokemonMutableLiveData = MutableLiveData<Boolean>()
    val shouldShowTypeListPokemon: LiveData<Boolean>
        get() = _shouldShowTypeListPokemonMutableLiveData

    private val _getAbilityDetailMutableLiveData = MutableLiveData<AbilityDetail>()
    val getAbilityDetailLiveData: LiveData<AbilityDetail>
        get() = _getAbilityDetailMutableLiveData

    private val _getTypeDetailMutableLiveData = MutableLiveData<TypeDetail>()
    val getTypeDetailLiveData: LiveData<TypeDetail>
        get() = _getTypeDetailMutableLiveData

    /** Region serviceCalls */
    fun getListPokemon(page: Int, offset: Int) {
        viewModelScope.launch {
            val homePokemonList = pokedexUseCase.invokeListPokemon(
                page,
                offset
            )
            _getListPokemonMutableLiveData.postValue(homePokemonList)
        }
    }

    fun searchPokemon(idOrName: String) {
        viewModelScope.launch {
            val pokemonResult = pokedexUseCase.invokePokemon(idOrName)
            _getPokemonMutableLiveData.postValue(pokemonResult)
        }

        viewModelScope.launch {
            val glitchPokemonResult = pokedexUseCase.invokeGlitchPokemon(idOrName)

            try {
                _getGlitchPokemonMutableLiveData.postValue(glitchPokemonResult[0])
            } catch (e: Exception) {
                _getGlitchPokemonMutableLiveData.postValue(GlitchPokemon())
            }
        }
    }

    fun searchTypeDetail(id: String) {
        viewModelScope.launch {
            _shouldShowTypeListPokemonMutableLiveData.postValue(true)
            val typeResult = pokedexUseCase.invokeTypeDetail(id)
            _getTypeDetailMutableLiveData.postValue(typeResult)
        }
    }

    fun dontShowTypeListPokemon() {
        _shouldShowTypeListPokemonMutableLiveData.postValue(false)
    }

    fun searchAbilityDetail(id: String) {
        viewModelScope.launch {
            _shouldShowAbilityDescriptionMutableLiveData.postValue(true)
            val abilityResult = pokedexUseCase.invokeAbilityDetail(id)
            _getAbilityDetailMutableLiveData.postValue(abilityResult)
        }
    }

    fun dontShowAbilityDescription() {
        _shouldShowAbilityDescriptionMutableLiveData.postValue(false)
    }
}