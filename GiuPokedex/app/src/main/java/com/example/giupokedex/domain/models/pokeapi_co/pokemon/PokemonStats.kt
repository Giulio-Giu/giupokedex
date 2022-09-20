package com.example.giupokedex.domain.models.pokeapi_co.pokemon

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.detail.StatDetail
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonStats(
    var baseValue: Int = 0,
    var stat: StatDetail = StatDetail(),
) : Parcelable
