package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.generations

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toPokemonVersionDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations.Generation7Response
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import com.example.giupokedex.domain.models.pokeapi_co.base.generations.Generation7

fun Generation7Response.toGeneration7DomainModel() = Generation7(
    icons = icons?.toPokemonVersionDomainModel() ?: PokemonVersion(),
    ultra_sun_ultra_moon = ultra_sun_ultra_moon?.toPokemonVersionDomainModel() ?: PokemonVersion(),
)