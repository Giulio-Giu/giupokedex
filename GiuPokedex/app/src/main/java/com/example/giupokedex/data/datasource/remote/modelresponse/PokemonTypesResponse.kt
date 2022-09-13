package com.example.giupokedex.data.datasource.remote.modelresponse

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.base.TypeDetailResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonTypesResponse(
    var type: TypeDetailResponse? = null,
) : Parcelable
