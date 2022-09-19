package com.example.giupokedex.data.datasource.mappers.pokeapi_co.pokemon

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toAbilityDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon.PokemonAbilitiesResponse
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonAbilities
import com.example.giupokedex.domain.models.pokeapi_co.base.Ability

fun List<PokemonAbilitiesResponse>.toListPokemonAbilitiesDomainModel() = mapNotNull {
    try {
        it.toPokemonAbilitiesDomainModel()
    } catch (e: Exception) {
        null
    }
}

fun PokemonAbilitiesResponse.toPokemonAbilitiesDomainModel() = PokemonAbilities(
    ability = ability?.toAbilityDomainModel() ?: Ability()
)