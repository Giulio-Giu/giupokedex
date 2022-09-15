package com.example.giupokedex.domain.models.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation6(
    var omegaruby_alphasapphire: PokemonVersion = PokemonVersion(),
    var x_y: PokemonVersion = PokemonVersion(),
) : Parcelable