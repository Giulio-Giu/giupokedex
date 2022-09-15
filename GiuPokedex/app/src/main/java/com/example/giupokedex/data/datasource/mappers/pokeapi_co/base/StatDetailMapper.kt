package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.StatDetailResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.StatDetail

fun StatDetailResponse.toStatDetailDomainModel() = StatDetail(
    id = id ?: 0,
    name = name.orEmpty()
)