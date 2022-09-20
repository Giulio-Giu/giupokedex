package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//info do tipo que tem na lista de tipos do pokemon
@Parcelize
data class TypeResponse(
    var name: String? = null,
    var url: String? = null
) : Parcelable
