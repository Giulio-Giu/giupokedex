package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.AbilityEffectLanguageResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.AbilityEffectLanguage

fun AbilityEffectLanguageResponse.toAbilityEffectLanguageDomainModel() = AbilityEffectLanguage(
    name = name.orEmpty(),
    url = url.orEmpty(),
)