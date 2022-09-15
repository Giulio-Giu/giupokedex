package com.example.giupokedex.domain.models.pokeapi_co.base

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeDetail(
    var id: Int = 1,
    var name: String = "",
    @SerializedName("pokemon")
    var listPokemons: List<TypesPokemon> = emptyList(),
) : Parcelable
