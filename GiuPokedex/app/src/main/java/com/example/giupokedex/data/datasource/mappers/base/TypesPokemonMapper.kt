package com.example.giupokedex.data.datasource.mappers.base

import com.example.giupokedex.data.datasource.remote.modelresponse.base.TypesPokemonResponse
import com.example.giupokedex.domain.models.base.TypesPokemon

fun TypesPokemonResponse.toTypesPokemonDomainModel() = TypesPokemon(
    name = name.orEmpty(),
    url = url.orEmpty(),
)