package com.example.giupokedex.domain.models.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation1(
    var red_blue: PokemonVersion = PokemonVersion(),
    var gold: PokemonVersion = PokemonVersion(),
) : Parcelable