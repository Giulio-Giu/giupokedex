package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AbilityEffectResponse(
    var effect: String? = null,
    var short_effect: String? = null
) : Parcelable