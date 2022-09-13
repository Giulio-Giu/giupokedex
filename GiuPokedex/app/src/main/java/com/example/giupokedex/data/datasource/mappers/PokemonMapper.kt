package com.example.giupokedex.data.datasource.mappers

import com.example.giupokedex.data.datasource.remote.modelresponse.PokemonResponse
import com.example.giupokedex.domain.models.Pokemon
import com.example.giupokedex.domain.models.PokemonSprites

fun PokemonResponse.toPokemonDomainModel() = Pokemon(
    id = id ?: 0,
    name = name.orEmpty(),
    height = height ?: 0,
    weight = weight ?: 0,
    sprites = sprites?.toPokemonSpritesDomainModel() ?: PokemonSprites(),
    abilities = abilities?.toListPokemonAbilitiesDomainModel().orEmpty(),


)

/*    var id: Int = 0,
    var name: String = "",
    var height: Int = 0,
    var weight: Int = 0,
    var sprites: PokemonSprites = PokemonSprites(),
    var abilities: List<PokemonAbilities> = emptyList(),
    var stats: List<PokemonStats> = emptyList(),
    var types: List<PokemonTypes> = emptyList(),
    var typesPokemon: TypesPokemon = TypesPokemon(),

 */