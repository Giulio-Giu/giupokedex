package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation1Response(
    @SerializedName("red-blue")
    var red_blue: PokemonVersionResponse? = null,

    @SerializedName("yellow")
    var gold: PokemonVersionResponse? = null,
) : Parcelable