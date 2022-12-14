package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.AbilityResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAbilitiesResponse(
    var ability: AbilityResponse? = null,
) : Parcelable
