package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypeResponse
import kotlinx.parcelize.Parcelize

//lista de tipos que um pokemon tem
@Parcelize
data class PokemonTypesResponse(
    var type: TypeResponse? = null,
) : Parcelable
