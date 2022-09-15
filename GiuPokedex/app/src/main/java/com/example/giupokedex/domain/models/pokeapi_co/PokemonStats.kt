package com.example.giupokedex.domain.models.pokeapi_co

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.StatDetail
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonStats(
    var baseValue: Int = 0,
    var stat: StatDetail = StatDetail(),
) : Parcelable
