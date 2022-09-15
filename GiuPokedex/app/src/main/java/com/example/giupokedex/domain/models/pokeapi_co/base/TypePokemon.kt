package com.example.giupokedex.domain.models.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//info sobre o pokemon que tem na lista de pokemons do tipo
@Parcelize
data class TypePokemon(
    var name: String? = null,
    var url: String? = null,
) : Parcelable