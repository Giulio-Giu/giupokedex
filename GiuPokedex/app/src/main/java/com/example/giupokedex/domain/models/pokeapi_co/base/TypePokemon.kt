package com.example.giupokedex.domain.models.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//info sobre o pokemon que tem na lista de pokemons do tipo
@Parcelize
data class TypePokemon(
    var name: String = "",
    var url: String = "",
) : Parcelable {
    fun getImageUrl(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonNumber()}.png"

    fun getPokemonNumber(): String = url.split("/".toRegex()).dropLast(1).last()
}