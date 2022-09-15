package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.generations

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toPokemonVersionDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations.Generation3Response
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import com.example.giupokedex.domain.models.pokeapi_co.base.generations.Generation3

fun Generation3Response.toGeneration3DomainModel() = Generation3(
    emerald = emerald?.toPokemonVersionDomainModel() ?: PokemonVersion(),
    firered_leafgreen = firered_leafgreen?.toPokemonVersionDomainModel() ?: PokemonVersion(),
    ruby_sapphire = ruby_sapphire?.toPokemonVersionDomainModel() ?: PokemonVersion(),
)