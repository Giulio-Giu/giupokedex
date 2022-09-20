package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonVersionResponse(
    var back_default: String? = null,
    var back_female: String? = null,
    var back_shiny: String? = null,
    var back_shiny_female: String? = null,
    var back_shiny_transparent: String? = null,
    var back_gray: String? = null,
    var back_transparent: String? = null,
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null,
    var front_shiny_transparent: String? = null,
    var front_gray: String? = null,
    var front_transparent: String? = null,
) : Parcelable