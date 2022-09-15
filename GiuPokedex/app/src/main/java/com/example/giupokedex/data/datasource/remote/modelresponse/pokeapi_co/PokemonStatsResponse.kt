package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.StatDetailResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonStatsResponse(
    @SerializedName("base_stat")
    var baseValue: Int? = null, //max value can be 180 for now
    var stat: StatDetailResponse? = null,
) : Parcelable
