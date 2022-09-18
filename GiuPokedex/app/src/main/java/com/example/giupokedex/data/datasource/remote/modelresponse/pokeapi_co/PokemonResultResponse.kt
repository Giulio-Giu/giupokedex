package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonResultResponse(
    var name: String? = null,
    var url: String? = null,
) : Parcelable