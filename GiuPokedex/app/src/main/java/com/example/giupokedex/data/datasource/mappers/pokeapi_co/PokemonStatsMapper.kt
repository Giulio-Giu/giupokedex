package com.example.giupokedex.data.datasource.mappers

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toStatDetailDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.PokemonStatsResponse
import com.example.giupokedex.domain.models.pokeapi_co.PokemonStats
import com.example.giupokedex.domain.models.pokeapi_co.base.StatDetail

fun List<PokemonStatsResponse>.toListPokemonStatsDomainModel() = mapNotNull {
    try {
        it.toPokemonStatsDomainModel()
    } catch (e: Exception) {
        null
    }
}

fun PokemonStatsResponse.toPokemonStatsDomainModel() = PokemonStats(
    baseValue = baseValue ?: 0,
    stat = stat?.toStatDetailDomainModel() ?: StatDetail()
)