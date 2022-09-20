package com.example.giupokedex.data.datasource.mappers.pokeapi_co.detail

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.StatDetailResponse
import com.example.giupokedex.domain.models.pokeapi_co.detail.StatDetail

fun StatDetailResponse.toStatDetailDomainModel() = StatDetail(
    id = id ?: 0,
    name = name.orEmpty()
)