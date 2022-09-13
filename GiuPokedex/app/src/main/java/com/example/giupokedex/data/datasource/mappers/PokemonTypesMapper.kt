package com.example.giupokedex.data.datasource.mappers

import com.example.giupokedex.data.datasource.mappers.base.toTypeDetailDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.PokemonTypesResponse
import com.example.giupokedex.domain.models.PokemonTypes
import com.example.giupokedex.domain.models.base.TypeDetail

fun List<PokemonTypesResponse>.toListPokemonTypesDomainModel() = mapNotNull {
    try {
        it.toPokemonTypesDomainModel()
    } catch (e: Exception) {
        null
    }
}

fun PokemonTypesResponse.toPokemonTypesDomainModel() = PokemonTypes(
    type = type?.toTypeDetailDomainModel() ?: TypeDetail()
)