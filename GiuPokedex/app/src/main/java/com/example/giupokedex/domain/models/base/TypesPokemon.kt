package com.example.giupokedex.domain.models.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypesPokemon(
    var name: String = "",
    var url: String = ""
) : Parcelable
