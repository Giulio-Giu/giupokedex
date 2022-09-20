package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion

fun PokemonVersionResponse.toPokemonVersionDomainModel() = PokemonVersion(
    back_default = back_default.orEmpty(),
    back_female = back_female.orEmpty(),
    back_shiny = back_shiny.orEmpty(),
    back_shiny_female = back_shiny_female.orEmpty(),
    back_shiny_transparent = back_shiny_transparent.orEmpty(),
    back_gray = back_gray.orEmpty(),
    back_transparent = back_transparent.orEmpty(),
    front_default = front_default.orEmpty(),
    front_female = front_female.orEmpty(),
    front_shiny = front_shiny.orEmpty(),
    front_shiny_female = front_shiny_female.orEmpty(),
    front_shiny_transparent = front_shiny_transparent.orEmpty(),
    front_gray = front_gray.orEmpty(),
    front_transparent = front_transparent.orEmpty(),
)