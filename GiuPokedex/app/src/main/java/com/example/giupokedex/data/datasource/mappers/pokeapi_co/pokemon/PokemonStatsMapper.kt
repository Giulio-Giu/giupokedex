package com.example.giupokedex.data.datasource.mappers.pokeapi_co.pokemon

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.detail.toStatDetailDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon.PokemonStatsResponse
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonStats
import com.example.giupokedex.domain.models.pokeapi_co.detail.StatDetail

fun List<PokemonStatsResponse>.toListPokemonStatsDomainModel() = mapNotNull {
    try {
        it.toPokemonStatsDomainModel()
    } catch (e: Exception) {
        null
    }
}

fun PokemonStatsResponse.toPokemonStatsDomainModel() = PokemonStats(
    baseValue = base_stat ?: 0,
    stat = stat?.toStatDetailDomainModel() ?: StatDetail()
)