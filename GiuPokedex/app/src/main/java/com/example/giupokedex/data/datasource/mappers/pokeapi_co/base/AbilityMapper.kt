package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.AbilityResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.Ability

fun AbilityResponse.toAbilityDomainModel() = Ability(
    name = name.orEmpty(),
    url = url.orEmpty(),
)