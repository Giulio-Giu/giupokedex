package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypesPokemonResponse(
    var name: String? = null,
    var url: String? = null
) : Parcelable
