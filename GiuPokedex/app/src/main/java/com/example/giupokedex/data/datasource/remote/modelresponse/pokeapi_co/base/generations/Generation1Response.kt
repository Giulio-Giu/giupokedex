package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation1Response(
    var `red-blue`: PokemonVersionResponse? = null,
    var yellow: PokemonVersionResponse? = null,
) : Parcelable