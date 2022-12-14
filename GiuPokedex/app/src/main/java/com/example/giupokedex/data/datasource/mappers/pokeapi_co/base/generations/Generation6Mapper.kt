package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.generations

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toPokemonVersionDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations.Generation6Response
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import com.example.giupokedex.domain.models.pokeapi_co.base.generations.Generation6

fun Generation6Response.toGeneration6DomainModel() = Generation6(
    omegaruby_alphasapphire = `omegaruby-alphasapphire`?.toPokemonVersionDomainModel()
        ?: PokemonVersion(),
    x_y = `x-y`?.toPokemonVersionDomainModel() ?: PokemonVersion(),
)