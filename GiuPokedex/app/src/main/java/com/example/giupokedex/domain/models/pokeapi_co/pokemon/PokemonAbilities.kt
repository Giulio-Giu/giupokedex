package com.example.giupokedex.domain.models.pokeapi_co.pokemon

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.detail.AbilityDetail
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAbilities(
    var ability: AbilityDetail = AbilityDetail(),
) : Parcelable
