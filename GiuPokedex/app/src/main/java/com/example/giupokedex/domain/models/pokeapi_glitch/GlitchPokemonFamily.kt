package com.example.giupokedex.domain.models.pokeapi_glitch

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GlitchPokemonFamily(
    var id: Int = 0,
    var evolutionStage: Int = 0,
    var evolutionLine: List<String> = emptyList(),
) : Parcelable