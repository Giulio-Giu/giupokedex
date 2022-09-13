package com.example.giupokedex.data.datasource.remote.modelresponse.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypesPokemonResponse(
    var name: String? = null,
    var url: String? = null
) : Parcelable
