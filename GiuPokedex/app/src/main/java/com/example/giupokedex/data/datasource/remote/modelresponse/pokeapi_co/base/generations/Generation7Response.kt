package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation7Response(
    var icons: PokemonVersionResponse? = null,
    var `ultra-sun-ultra-moon`: PokemonVersionResponse? = null
) : Parcelable