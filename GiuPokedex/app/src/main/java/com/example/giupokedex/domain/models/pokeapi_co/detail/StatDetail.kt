package com.example.giupokedex.domain.models.pokeapi_co.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatDetail(
    var id: Int = 1,
    var name: String = "",
) : Parcelable
