package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AbilityDetailResponse(
    var id: Int? = null,
    var name: String? = null,
    var effect_entries: List<AbilityEffectResponse>? = null,
) : Parcelable
