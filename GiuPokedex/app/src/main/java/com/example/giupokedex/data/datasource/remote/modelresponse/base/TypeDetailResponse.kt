package com.example.giupokedex.data.datasource.remote.modelresponse.base

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.PokemonResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeDetailResponse(
    var id: Int? = null,
    var name: String? = null,
    @SerializedName("pokemon")
    var listPokemons: List<PokemonResponse>? = null,
) : Parcelable