package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.AbilityDetailResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAbilitiesResponse(
    var ability: AbilityDetailResponse? = null,
) : Parcelable
