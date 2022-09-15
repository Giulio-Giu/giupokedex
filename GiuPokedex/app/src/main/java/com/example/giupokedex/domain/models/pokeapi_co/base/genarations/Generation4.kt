package com.example.giupokedex.domain.models.pokeapi_co.base.genarations

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonVersion
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation4(
    var diamond_pearl: PokemonVersion = PokemonVersion(),
    var heartgold_soulsilver: PokemonVersion = PokemonVersion(),
    var platinum: PokemonVersion = PokemonVersion(),
) : Parcelable