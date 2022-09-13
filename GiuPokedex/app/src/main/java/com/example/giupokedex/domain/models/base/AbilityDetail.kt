package com.example.giupokedex.domain.models.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AbilityDetail(
    var id: Int = 0,
    var name: String = "",
    var effect_entries: List<AbilityEffect> = emptyList(),
) : Parcelable
