package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypesPokemonResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.TypesPokemon

fun TypesPokemonResponse.toTypesPokemonDomainModel() = TypesPokemon(
    name = name.orEmpty(),
    url = url.orEmpty(),
)