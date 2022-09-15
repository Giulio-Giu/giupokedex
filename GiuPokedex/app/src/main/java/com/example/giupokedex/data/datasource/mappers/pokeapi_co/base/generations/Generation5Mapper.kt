package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.generations

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toPokemonVersionDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.genarations.Generation5Response
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import com.example.giupokedex.domain.models.pokeapi_co.base.genarations.Generation5

fun Generation5Response.toGeneration5DomainModel() = Generation5(
    black_white = black_white?.toPokemonVersionDomainModel() ?: PokemonVersion(),
)