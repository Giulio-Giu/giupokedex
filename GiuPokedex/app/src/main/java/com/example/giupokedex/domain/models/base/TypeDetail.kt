package com.example.giupokedex.domain.models.base

import android.os.Parcelable
import com.example.giupokedex.domain.models.Pokemon
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeDetail(
    var id: Int = 0,
    var name: String = "",
    @SerializedName("pokemon")
    var listPokemons: List<Pokemon> = emptyList(),
) : Parcelable
