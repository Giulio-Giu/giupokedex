package com.example.giupokedex.data.datasource.mappers

import com.example.giupokedex.data.datasource.remote.modelresponse.base.AbilityEffectResponse
import com.example.giupokedex.domain.models.base.AbilityEffect

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