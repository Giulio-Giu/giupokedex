package com.example.giupokedex.data.datasource.mappers

import com.example.giupokedex.data.datasource.remote.modelresponse.PokemonAbilitiesResponse
import com.example.giupokedex.domain.models.PokemonAbilities
import com.example.giupokedex.domain.models.base.AbilityDetail

fun List<PokemonAbilitiesResponse>.toListPokemonAbilitiesDomainModel() = mapNotNull {
    try {
        it.toPokemonAbilitiesDomainModel()
    } catch (e: Exception) {
        null
    }
}

fun PokemonAbilitiesResponse.toPokemonAbilitiesDomainModel() = PokemonAbilities(
    ability = ability?.toAbilityDetailDomainModel() ?: AbilityDetail()
)