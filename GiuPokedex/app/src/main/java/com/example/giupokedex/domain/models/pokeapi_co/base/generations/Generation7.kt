package com.example.giupokedex.domain.models.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation7(
    var icons: PokemonVersion = PokemonVersion(),
    var ultra_sun_ultra_moon: PokemonVersion = PokemonVersion(),
) : Parcelable