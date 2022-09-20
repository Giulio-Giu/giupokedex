package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonResponse(
    var id: Int? = null,
    var name: String? = null,
    var height: Int? = null,
    var weight: Int? = null,
    var base_experience: Int? = null,
    var sprites: PokemonSpritesResponse? = null,
    var abilities: List<PokemonAbilitiesResponse>? = null,
    var stats: List<PokemonStatsResponse>? = null,
    var types: List<PokemonTypesResponse>? = null,
) : Parcelable