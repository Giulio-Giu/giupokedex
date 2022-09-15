package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonGenerationsResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonSpritesResponse(
    var back_default: String? = null,
    var back_female: String? = null,
    var back_shiny: String? = null,
    var back_shiny_female: String? = null,
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null,

    @SerializedName("versions")
    var generations: PokemonGenerationsResponse? = null
) : Parcelable
