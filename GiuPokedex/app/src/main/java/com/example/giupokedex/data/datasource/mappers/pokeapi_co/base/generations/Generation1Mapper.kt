package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.generations

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toPokemonVersionDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations.Generation1Response
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import com.example.giupokedex.domain.models.pokeapi_co.base.generations.Generation1

fun Generation1Response.toGeneration1DomainModel() = Generation1(
    red_blue = `red-blue`?.toPokemonVersionDomainModel() ?: PokemonVersion(),
    gold = yellow?.toPokemonVersionDomainModel() ?: PokemonVersion(),
)