package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation5Response(
    var `black-white`: PokemonVersionResponse? = null,
) : Parcelable