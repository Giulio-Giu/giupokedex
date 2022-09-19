package com.example.giupokedex.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.giupokedex.R
import com.example.giupokedex.domain.models.pokeapi_co.ListPokemon
import com.example.giupokedex.domain.models.pokeapi_co.detail.AbilityDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.StatDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.TypeDetail
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.Pokemon
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon
import com.example.giupokedex.domain.usecases.abs.PokedexUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val pokedexUseCase: PokedexUseCase,
    private val application: Application
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

    private val _shouldShowAbilityMutableLiveData = MutableLiveData<Boolean>()
    val shouldShowAbility: LiveData<Boolean>
    get() = _shouldShowAbilityMutableLiveData

    private val _getAbilityDetailMutableLiveData = MutableLiveData<AbilityDetail>()
    val getAbilityDetailLiveData: LiveData<AbilityDetail>
        get() = _getAbilityDetailMutableLiveData

//    private val _getStatDetailMutableLiveData = MutableLiveData<StatDetail>()
//    val getStatDetailLiveData: LiveData<StatDetail>
//        get() = _getStatDetailMutableLiveData

    private val _getTypeDetailMutableLiveData = MutableLiveData<TypeDetail>()
    val getTypeDetailLiveData: LiveData<TypeDetail>
        get() = _getTypeDetailMutableLiveData

    /** Region serviceCalls */
    fun getListPokemon(page: Int) {
        viewModelScope.launch {
            val homePokemonList = pokedexUseCase.invokeListPokemon(
                page,
                application.resources.getInteger(R.integer.PAGING_SIZE)
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

    fun searchAbilityDetail(id: String) {
        viewModelScope.launch {
            _shouldShowAbilityMutableLiveData.postValue(true)
            val abilityResult = pokedexUseCase.invokeAbilityDetail(id)
            _getAbilityDetailMutableLiveData.postValue(abilityResult)
        }
    }

    fun dontShowAbility(){
        _shouldShowAbilityMutableLiveData.postValue(false)
    }

    fun searchTypeDetail(id: String) {
        viewModelScope.launch {
            val typeResult = pokedexUseCase.invokeTypeDetail(id)
            _getTypeDetailMutableLiveData.postValue(typeResult)
        }
    }
}