package com.example.giupokedex.domain.models.pokeapi_co

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.AbilityDetail
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAbilities(
    var ability: AbilityDetail = AbilityDetail(),
) : Parcelable
