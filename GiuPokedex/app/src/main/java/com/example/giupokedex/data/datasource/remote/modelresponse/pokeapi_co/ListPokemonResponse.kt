package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListPokemonResponse (
    var count: Int? = null,
    var next: String? = null,
    var previous: String? = null,
    var results: List<PokemonResultResponse>? = null,
) : Parcelable