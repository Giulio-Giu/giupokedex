package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.generations

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toPokemonVersionDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.genarations.Generation4Response
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import com.example.giupokedex.domain.models.pokeapi_co.base.genarations.Generation4

fun Generation4Response.toGeneration4DomainModel() = Generation4(
    diamond_pearl = diamond_pearl?.toPokemonVersionDomainModel() ?: PokemonVersion(),
    heartgold_soulsilver = heartgold_soulsilver?.toPokemonVersionDomainModel() ?: PokemonVersion(),
    platinum = platinum?.toPokemonVersionDomainModel() ?: PokemonVersion(),
)