package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.generations

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toPokemonVersionDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.genarations.Generation2Response
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import com.example.giupokedex.domain.models.pokeapi_co.base.genarations.Generation2

fun Generation2Response.toGeneration2DomainModel() = Generation2(
    gold = gold?.toPokemonVersionDomainModel() ?: PokemonVersion(),
    crystal = crystal?.toPokemonVersionDomainModel() ?: PokemonVersion(),
    silver = silver?.toPokemonVersionDomainModel() ?: PokemonVersion(),
)