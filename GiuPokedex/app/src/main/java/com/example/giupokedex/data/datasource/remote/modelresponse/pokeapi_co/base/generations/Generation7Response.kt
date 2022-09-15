package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation7Response(
    var icons: PokemonVersionResponse? = null,
    @SerializedName("ultra-sun-ultra-moon")
    var ultra_sun_ultra_moon: PokemonVersionResponse? = null
) : Parcelable