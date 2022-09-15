package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.genarations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation4Response(
    @SerializedName("diamond-pearl")
    var diamond_pearl: PokemonVersionResponse? = null,

    @SerializedName("heartgold-soulsilver")
    var heartgold_soulsilver: PokemonVersionResponse? = null,

    @SerializedName("platinum")
    var platinum: PokemonVersionResponse? = null,
) : Parcelable