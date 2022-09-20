package com.example.giupokedex.domain.models.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//lista de pokemons que um tipo tem
@Parcelize
data class TypePokemonsList(
    var pokemon: TypePokemon = TypePokemon(),
) : Parcelable