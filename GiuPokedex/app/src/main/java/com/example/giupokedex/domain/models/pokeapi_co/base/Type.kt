package com.example.giupokedex.domain.models.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//info do tipo que tem na lista de tipos do pokemon
@Parcelize
data class Type(
    var name: String = "",
    var url: String = ""
) : Parcelable
