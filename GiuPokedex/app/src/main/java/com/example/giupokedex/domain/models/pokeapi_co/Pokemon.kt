package com.example.giupokedex.domain.models.pokeapi_co

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.TypesPokemon
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    var id: Int = 1,
    var name: String = "",
    var height: Int = 0,
    var weight: Int = 0,
    var sprites: PokemonSprites = PokemonSprites(),
    var abilities: List<PokemonAbilities> = emptyList(),
    var stats: List<PokemonStats> = emptyList(),
    var types: List<PokemonTypes> = emptyList(),
) : Parcelable