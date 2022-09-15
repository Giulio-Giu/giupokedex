package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation3Response(
    @SerializedName("emerald")
    var emerald: PokemonVersionResponse? = null,

    @SerializedName("firered-leafgreen")
    var firered_leafgreen: PokemonVersionResponse? = null,

    @SerializedName("ruby-sapphire")
    var ruby_sapphire: PokemonVersionResponse? = null,
) : Parcelable