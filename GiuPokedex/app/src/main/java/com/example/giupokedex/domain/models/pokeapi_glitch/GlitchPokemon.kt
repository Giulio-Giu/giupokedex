package com.example.giupokedex.domain.models.pokeapi_glitch

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GlitchPokemon(
    var number: Int = 1,
    var name: String = "",
    var specie: String = "",
    var description: String = "",
    var family: GlitchPokemonFamily = GlitchPokemonFamily(),
    var starter: Boolean = false,
    var legendary: Boolean = false,
    var mythical: Boolean = false,
    var ultraBeast: Boolean = false,
    var mega: Boolean = false,
) : Parcelable