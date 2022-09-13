package com.example.giupokedex.domain.models

import android.os.Parcelable
import com.example.giupokedex.domain.models.base.AbilityDetail
import com.example.giupokedex.domain.models.base.AbilityEffect
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.parcelableCreator

@Parcelize
data class PokemonAbilities(
    var ability: AbilityDetail = AbilityDetail(),
) : Parcelable
