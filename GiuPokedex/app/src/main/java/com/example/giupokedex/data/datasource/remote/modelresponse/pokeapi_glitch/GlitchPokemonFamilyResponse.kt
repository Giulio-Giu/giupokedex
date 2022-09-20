package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_glitch

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GlitchPokemonFamilyResponse(
    var id: Int? = null,
    var evolutionStage: Int? = null,
    var evolutionLine: List<String>? = null,
) : Parcelable