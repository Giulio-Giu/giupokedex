package com.example.giupokedex.data.datasource.mappers

import com.example.giupokedex.data.datasource.mappers.base.toStatDetailDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.PokemonStatsResponse
import com.example.giupokedex.domain.models.PokemonStats
import com.example.giupokedex.domain.models.base.StatDetail

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