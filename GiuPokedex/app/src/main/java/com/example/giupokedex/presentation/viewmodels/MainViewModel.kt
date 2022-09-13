package com.example.giupokedex.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giupokedex.domain.models.Pokemon
import com.example.giupokedex.domain.models.base.AbilityDetail
import com.example.giupokedex.domain.models.base.StatDetail
import com.example.giupokedex.domain.models.base.TypeDetail
import com.example.giupokedex.domain.usecases.abs.PokedexUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val pokedexUseCase: PokedexUseCase
) : ViewModel() {
    /** Region LiveData */
    private val _getPokemonMutableLiveData = MutableLiveData<Pokemon>()
    val getPokemonLiveData: LiveData<Pokemon>
        get() = _getPokemonMutableLiveData

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
    fun getPokemon(idOrName: String) {
        viewModelScope.launch {
            val pokemonResult = pokedexUseCase.invokePokemon(idOrName)
            _getPokemonMutableLiveData.postValue(pokemonResult)
        }
    }

    fun getAbilityDetail(id: String) {
        viewModelScope.launch {
            val abilityResult = pokedexUseCase.invokeAbilityDetail(id)
            _getAbilityDetailMutableLiveData.postValue(abilityResult)
        }
    }

    fun getStatDetail(id: String) {
        viewModelScope.launch {
            val statResult = pokedexUseCase.invokeStatDetail(id)
            _getStatDetailMutableLiveData.postValue(statResult)
        }
    }

    fun getTypeDetail(id: String) {
        viewModelScope.launch {
            val typeResult = pokedexUseCase.invokeTypeDetail(id)
            _getTypeDetailMutableLiveData.postValue(typeResult)
        }
    }
}