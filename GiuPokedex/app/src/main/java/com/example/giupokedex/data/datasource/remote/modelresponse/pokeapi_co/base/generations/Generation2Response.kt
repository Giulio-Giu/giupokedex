package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation2Response(
    var crystal: PokemonVersionResponse? = null,
    var gold: PokemonVersionResponse? = null,
    var silver: PokemonVersionResponse? = null,
) : Parcelable