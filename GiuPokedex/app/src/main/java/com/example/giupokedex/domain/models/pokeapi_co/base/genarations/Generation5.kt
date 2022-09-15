package com.example.giupokedex.domain.models.pokeapi_co.base.genarations

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation5(
    var black_white: PokemonVersion = PokemonVersion(),
) : Parcelable