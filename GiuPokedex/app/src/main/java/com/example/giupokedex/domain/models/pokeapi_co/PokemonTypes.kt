package com.example.giupokedex.domain.models.pokeapi_co

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.TypeDetail
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonTypes(
    var type: TypeDetail = TypeDetail(),
) : Parcelable
