package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation6Response(
    var `omegaruby-alphasapphire`: PokemonVersionResponse? = null,
    var `x-y`: PokemonVersionResponse? = null
) : Parcelable