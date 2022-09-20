package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation4Response(
    var `diamond-pearl`: PokemonVersionResponse? = null,
    var `heartgold-soulsilver`: PokemonVersionResponse? = null,
    var platinum: PokemonVersionResponse? = null,
) : Parcelable