package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//info do habilidade que tem na lista de habilidades do pokemon
@Parcelize
data class AbilityResponse(
    var name: String? = null,
    var url: String? = null
) : Parcelable
