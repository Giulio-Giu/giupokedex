package com.example.giupokedex.domain.models.pokeapi_co.detail

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.AbilityEffect
import kotlinx.parcelize.Parcelize

@Parcelize
data class AbilityDetail(
    var id: Int = 0,
    var name: String = "",
    var effect_entries: List<AbilityEffect> = emptyList(), //[1] is in english
) : Parcelable
