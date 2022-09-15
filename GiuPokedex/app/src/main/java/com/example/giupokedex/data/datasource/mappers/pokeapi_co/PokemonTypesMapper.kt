package com.example.giupokedex.data.datasource.mappers

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toTypeDetailDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.ListPokemonTypesResponse
import com.example.giupokedex.domain.models.pokeapi_co.PokemonTypes
import com.example.giupokedex.domain.models.pokeapi_co.base.TypeDetail

fun List<ListPokemonTypesResponse>.toListPokemonTypesDomainModel() = mapNotNull {
    try {
        it.toPokemonTypesDomainModel()
    } catch (e: Exception) {
        null
    }
}

fun ListPokemonTypesResponse.toPokemonTypesDomainModel() = PokemonTypes(
    type = type?.toTypeDetailDomainModel() ?: TypeDetail()
)