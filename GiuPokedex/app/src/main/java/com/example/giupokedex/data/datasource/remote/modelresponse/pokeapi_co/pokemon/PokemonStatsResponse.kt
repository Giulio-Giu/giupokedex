package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.StatDetailResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonStatsResponse(
    var base_stat: Int? = null, //max value can be 180 for now
    var stat: StatDetailResponse? = null,
) : Parcelable
