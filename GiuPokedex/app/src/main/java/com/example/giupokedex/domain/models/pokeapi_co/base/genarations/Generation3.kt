package com.example.giupokedex.domain.models.pokeapi_co.base.genarations

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation3(
    var emerald: PokemonVersion = PokemonVersion(),
    var firered_leafgreen: PokemonVersion = PokemonVersion(),
    var ruby_sapphire: PokemonVersion = PokemonVersion(),
) : Parcelable