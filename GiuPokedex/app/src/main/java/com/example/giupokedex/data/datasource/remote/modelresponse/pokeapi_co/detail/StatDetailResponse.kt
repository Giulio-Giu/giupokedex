package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatDetailResponse(
    var id: Int? = null,
    var name: String? = null,
) : Parcelable
