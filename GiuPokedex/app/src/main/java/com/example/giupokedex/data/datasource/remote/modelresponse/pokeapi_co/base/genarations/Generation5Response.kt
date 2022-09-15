package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.genarations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation5Response(
    @SerializedName("black-white")
    var black_white: PokemonVersionResponse? = null,
) : Parcelable