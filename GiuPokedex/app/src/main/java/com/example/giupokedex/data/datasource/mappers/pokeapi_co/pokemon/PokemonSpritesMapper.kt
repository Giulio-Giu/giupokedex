package com.example.giupokedex.data.datasource.mappers.pokeapi_co.pokemon

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toPokemonGenerationsDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon.PokemonSpritesResponse
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonSprites
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonGenerations

fun PokemonSpritesResponse.toPokemonSpritesDomainModel() = PokemonSprites(
    back_default = back_default.orEmpty(),
    back_female = back_female.orEmpty(),
    back_shiny = back_shiny.orEmpty(),
    back_shiny_female = back_shiny_female.orEmpty(),
    front_default = front_default.orEmpty(),
    front_female = front_female.orEmpty(),
    front_shiny = front_shiny.orEmpty(),
    front_shiny_female = front_shiny_female.orEmpty(),
    generations = versions?.toPokemonGenerationsDomainModel() ?: PokemonGenerations(),
)