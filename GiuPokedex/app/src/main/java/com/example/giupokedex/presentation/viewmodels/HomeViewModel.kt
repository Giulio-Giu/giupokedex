package com.example.giupokedex.presentation.viewmodels

import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.*
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.Pokemon
import com.example.giupokedex.domain.models.pokeapi_co.detail.AbilityDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.StatDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.TypeDetail
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon
import com.example.giupokedex.domain.usecases.abs.PokedexUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val pokedexUseCase: PokedexUseCase
) : ViewModel() {
    /** Region LiveData */
     val _getPokemonMutableLiveData = MutableLiveData<Pokemon>()
//    val getPokemonLiveData: LiveData<Pokemon>
//        get() = _getPokemonMutableLiveData

     val _getGlitchPokemonMutableLiveData = MutableLiveData<GlitchPokemon>()
//    val getGlitchPokemonLiveData: LiveData<GlitchPokemon>
//        get() = _getGlitchPokemonMutableLiveData

    val getAllPokemonDataMediatorLiveData =
        MediatorLiveData<Pair<Pokemon?, GlitchPokemon?>>().apply {
            addSource(_getPokemonMutableLiveData) {
                value = Pair(it, _getGlitchPokemonMutableLiveData.value)
            }
            addSource(_getGlitchPokemonMutableLiveData) {
                value = Pair(_getPokemonMutableLiveData.value, it)
            }
        }

    private val _getAbilityDetailMutableLiveData = MutableLiveData<AbilityDetail>()
    val getAbilityDetailLiveData: LiveData<AbilityDetail>
        get() = _getAbilityDetailMutableLiveData

    private val _getStatDetailMutableLiveData = MutableLiveData<StatDetail>()
    val getStatDetailLiveData: LiveData<StatDetail>
        get() = _getStatDetailMutableLiveData

    private val _getTypeDetailMutableLiveData = MutableLiveData<TypeDetail>()
    val getTypeDetailLiveData: LiveData<TypeDetail>
        get() = _getTypeDetailMutableLiveData


    /** Region serviceCalls */
    fun searchPokemon(idOrName: String) {
        viewModelScope.launch {
            val pokemonResult = pokedexUseCase.invokePokemon(idOrName)
//            _getPokemonMutableLiveData.value = pokemonResult
            _getPokemonMutableLiveData.postValue(pokemonResult)
        }

        viewModelScope.launch {
            val glitchPokemonResult = pokedexUseCase.invokeGlitchPokemon(idOrName)
//            _getGlitchPokemonMutableLiveData.value = glitchPokemonResult
            try {
                _getGlitchPokemonMutableLiveData.postValue(glitchPokemonResult[0])
            } catch (e: Exception) {
                _getGlitchPokemonMutableLiveData.postValue(GlitchPokemon())
            }
        }
    }

    /*fun searchGlitchPokemon(idOrName: String) {
        viewModelScope.launch {
            val glitchPokemonResult = pokedexUseCase.invokeGlitchPokemon(idOrName)
//            _getGlitchPokemonMutableLiveData.value = glitchPokemonResult
            _getGlitchPokemonMutableLiveData.postValue(glitchPokemonResult[0])
        }
    }*/

    fun searchAbilityDetail(id: String) {
        viewModelScope.launch {
            val abilityResult = pokedexUseCase.invokeAbilityDetail(id)
            _getAbilityDetailMutableLiveData.postValue(abilityResult)
        }
    }

    fun searchStatDetail(id: String) {
        viewModelScope.launch {
            val statResult = pokedexUseCase.invokeStatDetail(id)
            _getStatDetailMutableLiveData.postValue(statResult)
        }
    }

    fun searchTypeDetail(id: String) {
        viewModelScope.launch {
            val typeResult = pokedexUseCase.invokeTypeDetail(id)
            _getTypeDetailMutableLiveData.postValue(typeResult)
        }
    }
}