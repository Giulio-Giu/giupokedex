package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypeDetailResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.TypeDetail

fun TypeDetailResponse.toTypeDetailDomainModel() = TypeDetail(
    id = id ?: 0,
    name = name.orEmpty()
)