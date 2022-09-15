package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.AbilityDetailResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.AbilityDetail

fun AbilityDetailResponse.toAbilityDetailDomainModel() = AbilityDetail(
    id = id ?: 0,
    name = name.orEmpty(),
    effect_entries = effect_entries?.toListAbilityEffectsDomainModel().orEmpty(),
)