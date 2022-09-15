package com.example.giupokedex.data.datasource.mappers

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.PokemonResponse
import com.example.giupokedex.domain.models.pokeapi_co.Pokemon
import com.example.giupokedex.domain.models.pokeapi_co.PokemonSprites

fun PokemonResponse.toPokemonDomainModel() = Pokemon(
    id = id ?: 0,
    name = name.orEmpty(),
    height = height ?: 0,
    weight = weight ?: 0,
    sprites = sprites?.toPokemonSpritesDomainModel() ?: PokemonSprites(),
    abilities = abilities?.toListPokemonAbilitiesDomainModel().orEmpty(),
    stats = stats?.toListPokemonStatsDomainModel().orEmpty(),
    types = types?.toListPokemonTypesDomainModel().orEmpty(),
)