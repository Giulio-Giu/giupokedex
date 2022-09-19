package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AbilityEffectLanguageResponse(
    var name: String? = null,
    var url: String? = null,
) : Parcelable