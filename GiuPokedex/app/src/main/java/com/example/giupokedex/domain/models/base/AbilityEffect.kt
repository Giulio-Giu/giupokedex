package com.example.giupokedex.domain.models.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AbilityEffect(
    var effect: String = "",
    var short_effect: String = ""
) : Parcelable