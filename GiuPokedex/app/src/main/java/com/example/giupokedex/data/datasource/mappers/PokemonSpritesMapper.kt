package com.example.giupokedex.data.datasource.mappers

import com.example.giupokedex.data.datasource.remote.modelresponse.PokemonSpritesResponse
import com.example.giupokedex.domain.models.PokemonSprites

fun PokemonSpritesResponse.toPokemonSpritesDomainModel() = PokemonSprites(
    back_default = back_default.orEmpty(),
    front_default = front_default.orEmpty(),
    back_female = back_female.orEmpty(),
    front_female = front_female.orEmpty(),
    back_shiny = back_shiny.orEmpty(),
    front_shiny = front_shiny.orEmpty(),
    back_shiny_female = back_shiny_female.orEmpty(),
    front_shiny_female = front_shiny_female.orEmpty(),
)