package com.example.giupokedex.domain.models.pokeapi_co.detail

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.TypePokemonsList
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeDetail(
    var id: Int = 1,
    var name: String = "",
    @SerializedName("pokemon")
    var listPokemons: List<TypePokemonsList> = emptyList(),
) : Parcelable
