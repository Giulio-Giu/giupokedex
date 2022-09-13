package com.example.giupokedex.data.datasource.remote.modelresponse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonSpritesResponse(
    var back_default: String? = null,
    var front_default: String? = null,
    var back_female: String? = null,
    var front_female: String? = null,
    var back_shiny: String? = null,
    var front_shiny: String? = null,
    var back_shiny_female: String? = null,
    var front_shiny_female: String? = null,
) : Parcelable
