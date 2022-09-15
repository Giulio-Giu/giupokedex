package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.generations

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypeResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.Type

fun TypeResponse.toTypeDomainModel() = Type(
    name = name.orEmpty(),
    url = url.orEmpty(),
)