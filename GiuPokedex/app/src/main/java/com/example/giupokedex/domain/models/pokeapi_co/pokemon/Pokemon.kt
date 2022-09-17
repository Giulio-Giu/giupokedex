package com.example.giupokedex.domain.models.pokeapi_co.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    var id: Int = 0,
    var name: String = "",
    var height: Int = 0,
    var weight: Int = 0,
    var expStat: Int = 0,
    var sprites: PokemonSprites = PokemonSprites(),
    var abilities: List<PokemonAbilities> = emptyList(),
    var stats: List<PokemonStats> = emptyList(),
    var pokemonTypes: List<PokemonTypes> = emptyList(),
) : Parcelable