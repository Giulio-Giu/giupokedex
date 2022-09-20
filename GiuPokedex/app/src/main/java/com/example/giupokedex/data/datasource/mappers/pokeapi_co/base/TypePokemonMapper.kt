package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypePokemonResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.TypePokemon

fun TypePokemonResponse.toTypePokemonDomainModel() = TypePokemon(
    name = name.orEmpty(),
    url = url.orEmpty(),
)