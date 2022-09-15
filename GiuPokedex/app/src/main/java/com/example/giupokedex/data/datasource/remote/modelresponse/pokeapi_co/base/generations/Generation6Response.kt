package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation6Response(
    @SerializedName("omegaruby-alphasapphire")
    var omegaruby_alphasapphire: PokemonVersionResponse? = null,

    @SerializedName("x-y")
    var x_y: PokemonVersionResponse? = null
) : Parcelable