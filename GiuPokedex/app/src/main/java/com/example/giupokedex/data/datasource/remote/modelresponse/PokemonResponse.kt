package com.example.giupokedex.data.datasource.remote.modelresponse

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.base.TypesPokemonResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonResponse(
    var id: Int? = null,
    var name: String? = null,
    var height: Int? = null,
    var weight: Int? = null,
    var sprites: PokemonSpritesResponse? = null,
    var abilities: List<PokemonAbilitiesResponse>? = null,
    var stats: List<PokemonStatsResponse>? = null,
    var types: List<PokemonTypesResponse>? = null,
    var typesPokemon: TypesPokemonResponse? = null,
) : Parcelable