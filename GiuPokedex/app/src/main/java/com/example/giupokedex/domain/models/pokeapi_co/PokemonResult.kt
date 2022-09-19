package com.example.giupokedex.domain.models.pokeapi_co

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonResult(
    var name: String = "",
    var url: String = "",
) : Parcelable {
    fun getImageUrl(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonNumber()}.png"

    fun getPokemonNumber(): String = url.split("/".toRegex()).dropLast(1).last()

    fun getItemPokemonNumberAndName(): String = "#${getPokemonNumber().padStart(3, '0')} - $name"
}