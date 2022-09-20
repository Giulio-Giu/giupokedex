package com.example.giupokedex.data.datasource.mappers.pokeapi_co

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.PokemonResultResponse
import com.example.giupokedex.domain.models.pokeapi_co.PokemonResult

fun List<PokemonResultResponse>.toListPokemonResultDomainModel() = mapNotNull {
    try {
        it.toPokemonResultDomainModel()
    } catch (e: Exception) {
        null
    }
}

fun PokemonResultResponse.toPokemonResultDomainModel() = PokemonResult(
    name = name.orEmpty(),
    url = url.orEmpty(),
)