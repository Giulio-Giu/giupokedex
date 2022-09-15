package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.AbilityEffectResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.AbilityEffect

fun List<AbilityEffectResponse>.toListAbilityEffectsDomainModel() = mapNotNull {
    try {
        it.toAbilityEffectDomainModel()
    } catch (e: Exception) {
        null
    }
}
fun AbilityEffectResponse.toAbilityEffectDomainModel() = AbilityEffect(
    effect = effect.orEmpty(),
    short_effect = short_effect.orEmpty(),
)