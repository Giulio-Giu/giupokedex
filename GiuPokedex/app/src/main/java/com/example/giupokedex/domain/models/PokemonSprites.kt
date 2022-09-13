package com.example.giupokedex.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonSprites(
    var back_default: String = "",
    var front_default: String = "",
    var back_female: String = "",
    var front_female: String = "",
    var back_shiny: String = "",
    var front_shiny: String = "",
    var back_shiny_female: String = "",
    var front_shiny_female: String = "",
) : Parcelable
