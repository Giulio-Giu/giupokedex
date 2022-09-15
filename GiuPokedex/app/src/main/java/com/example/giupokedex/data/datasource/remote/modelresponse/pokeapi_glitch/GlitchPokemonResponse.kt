package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_glitch

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GlitchPokemonResponse(
    var number: Int? = null,
    var name: String? = null,
    var specie: String? = null,
    var description: String? = null,
    var family: GlitchPokemonFamilyResponse? = null,
    var starter: Boolean? = null,
    var legendary: Boolean? = null,
    var mythical: Boolean? = null,
    var ultraBeast: Boolean? = null,
    var mega: Boolean? = null,
) : Parcelable