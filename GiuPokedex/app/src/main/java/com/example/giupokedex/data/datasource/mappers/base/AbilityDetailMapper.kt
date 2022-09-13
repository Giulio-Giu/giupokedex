package com.example.giupokedex.data.datasource.mappers

import com.example.giupokedex.data.datasource.remote.modelresponse.base.AbilityDetailResponse
import com.example.giupokedex.domain.models.base.AbilityDetail

fun AbilityDetailResponse.toAbilityDetailDomainModel() = AbilityDetail(
    id = id ?: 0,
    name = name.orEmpty(),
    effect_entries = effect_entries?.toListAbilityEffectsDomainModel().orEmpty(),
)