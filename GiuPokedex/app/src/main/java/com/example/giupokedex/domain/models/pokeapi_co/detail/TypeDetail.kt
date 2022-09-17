package com.example.giupokedex.domain.models.pokeapi_co.detail

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.TypePokemonsList
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeDetail(
    var id: Int = 0,
    var name: String = "",
    var pokemon: List<TypePokemonsList> = emptyList(),
) : Parcelable
