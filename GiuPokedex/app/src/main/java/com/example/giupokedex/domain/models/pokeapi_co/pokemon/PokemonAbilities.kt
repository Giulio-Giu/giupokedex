package com.example.giupokedex.domain.models.pokeapi_co.pokemon

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.Ability
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAbilities(
    var ability: Ability = Ability(),
) : Parcelable
