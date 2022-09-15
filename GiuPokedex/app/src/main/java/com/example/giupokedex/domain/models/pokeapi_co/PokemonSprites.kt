package com.example.giupokedex.domain.models.pokeapi_co

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonGenerations
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonSprites(
    var back_default: String = "",
    var back_female: String = "",
    var back_shiny: String = "",
    var back_shiny_female: String = "",
    var front_default: String = "",
    var front_female: String = "",
    var front_shiny: String = "",
    var front_shiny_female: String = "",

    var generations: PokemonGenerations = PokemonGenerations(),
) : Parcelable
