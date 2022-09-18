package com.example.giupokedex.data.datasource.mappers.pokeapi_co

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.ListPokemonResponse
import com.example.giupokedex.domain.models.pokeapi_co.ListPokemon

fun ListPokemonResponse.toListPokemonDomainModel() = ListPokemon(
    count = count ?: 0,
    next = next.orEmpty(),
    previous = previous.orEmpty(),
    results = results?.toListPokemonResultDomainModel().orEmpty()
)