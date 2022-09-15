package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.genarations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation2Response(
    @SerializedName("crystal")
    var crystal: PokemonVersionResponse? = null,

    @SerializedName("gold")
    var gold: PokemonVersionResponse? = null,

    @SerializedName("silver")
    var silver: PokemonVersionResponse? = null,
) : Parcelable