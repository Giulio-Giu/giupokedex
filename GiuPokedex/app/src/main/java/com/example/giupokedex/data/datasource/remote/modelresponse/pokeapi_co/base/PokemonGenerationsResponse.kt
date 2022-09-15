package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.genarations.*
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonGenerationsResponse(
    @SerializedName("generation-i")
    var generation_1: Generation1Response? = null,

    @SerializedName("generation-ii")
    var generation_2: Generation2Response? = null,

    @SerializedName("generation-iii")
    var generation_3: Generation3Response? = null,

    @SerializedName("generation-iv")
    var generation_4: Generation4Response? = null,

    @SerializedName("generation-v")
    var generation_5: Generation5Response? = null,

    @SerializedName("generation-vi")
    var generation_6: Generation6Response? = null,

    @SerializedName("generation-vii")
    var generation_7: Generation7Response? = null,

    @SerializedName("generation-viii")
    var generation_8: Generation8Response? = null,
) : Parcelable