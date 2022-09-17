package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonVersionResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Generation3Response(
    var emerald: PokemonVersionResponse? = null,
    var `firered-leafgreen`: PokemonVersionResponse? = null,
    var `ruby-sapphire`: PokemonVersionResponse? = null,
) : Parcelable