package com.example.giupokedex.data.datasource.mappers.pokeapi_co.pokemon

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon.PokemonResponse
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.Pokemon
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonSprites

fun PokemonResponse.toPokemonDomainModel() = Pokemon(
    id = id ?: 0,
    name = name.orEmpty(),
    height = height ?: 0,
    weight = weight ?: 0,
    expStat = base_experience ?: 0,
    sprites = sprites?.toPokemonSpritesDomainModel() ?: PokemonSprites(),
    abilities = abilities?.toListPokemonAbilitiesDomainModel().orEmpty(),
    stats = stats?.toListPokemonStatsDomainModel().orEmpty(),
    pokemonTypes = types?.toListPokemonTypesDomainModel().orEmpty(),
)