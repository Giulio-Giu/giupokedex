package com.example.giupokedex.domain.models.pokeapi_co.base

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AbilityEffectLanguage (
    var name: String = "",
    var url: String = "",
) : Parcelable