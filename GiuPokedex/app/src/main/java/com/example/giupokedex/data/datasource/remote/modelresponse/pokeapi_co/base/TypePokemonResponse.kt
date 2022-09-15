package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//info sobre o pokemon que tem na lista de pokemons do tipo
@Parcelize
data class TypePokemonResponse(
    var name: String? = null,
    var url: String? = null,
) : Parcelable