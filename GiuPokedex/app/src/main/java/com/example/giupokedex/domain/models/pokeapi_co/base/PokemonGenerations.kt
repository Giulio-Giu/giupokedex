package com.example.giupokedex.domain.models.pokeapi_co.base

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.generations.*
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonGenerations(
    var generation_1: Generation1 = Generation1(),
    var generation_2: Generation2 = Generation2(),
    var generation_3: Generation3 = Generation3(),
    var generation_4: Generation4 = Generation4(),
    var generation_5: Generation5 = Generation5(),
    var generation_6: Generation6 = Generation6(),
    var generation_7: Generation7 = Generation7(),
    var generation_8: Generation8 = Generation8(),
) : Parcelable