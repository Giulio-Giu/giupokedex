package com.example.giupokedex.data.datasource.mappers.pokeapi_co.pokemon

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toTypeDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon.PokemonTypesResponse
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonTypes
import com.example.giupokedex.domain.models.pokeapi_co.base.Type

fun List<PokemonTypesResponse>.toListPokemonTypesDomainModel() = mapNotNull {
    try {
        it.toPokemonTypesDomainModel()
    } catch (e: Exception) {
        null
    }
}

fun PokemonTypesResponse.toPokemonTypesDomainModel() = PokemonTypes(
    type = type?.toTypeDomainModel() ?: Type(),
)