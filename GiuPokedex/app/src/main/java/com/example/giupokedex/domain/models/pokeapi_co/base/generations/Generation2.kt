package com.example.giupokedex.domain.models.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation2(
    var crystal: PokemonVersion = PokemonVersion(),
    var gold: PokemonVersion = PokemonVersion(),
    var silver: PokemonVersion = PokemonVersion(),
) : Parcelable