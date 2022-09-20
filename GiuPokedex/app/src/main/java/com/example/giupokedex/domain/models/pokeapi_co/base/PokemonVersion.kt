package com.example.giupokedex.domain.models.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonVersion(
    var back_default: String = "",
    var back_female: String = "",
    var back_shiny: String = "",
    var back_shiny_female: String = "",
    var back_shiny_transparent: String = "",
    var back_gray: String = "",
    var back_transparent: String = "",
    var front_default: String = "",
    var front_female: String = "",
    var front_shiny: String = "",
    var front_shiny_female: String = "",
    var front_shiny_transparent: String = "",
    var front_gray: String = "",
    var front_transparent: String = "",
) : Parcelable