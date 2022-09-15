package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//lista de pokemons que um tipo tem
@Parcelize
data class TypePokemonsListResponse (
    var pokemon: TypePokemonResponse? = null,
) : Parcelable