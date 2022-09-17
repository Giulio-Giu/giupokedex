package com.example.giupokedex.domain.models.pokeapi_glitch

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GlitchPokemon(
    var number: Int = 0,
    var name: String = "",
    var species: String = "",
    var description: String = "",
    var family: GlitchPokemonFamily = GlitchPokemonFamily(),
    var image: String = "",
    var is_starter: Boolean = false,
    var is_legendary: Boolean = false,
    var is_mythical: Boolean = false,
    var is_ultraBeast: Boolean = false,
    var is_mega: Boolean = false,
) : Parcelable