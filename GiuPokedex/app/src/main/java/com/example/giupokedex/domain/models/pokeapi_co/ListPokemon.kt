package com.example.giupokedex.domain.models.pokeapi_co

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListPokemon(
    var count: Int = 0,
    var next: String = "",
    var previous: String = "",
    var results: List<PokemonResult> = emptyList(),
) : Parcelable