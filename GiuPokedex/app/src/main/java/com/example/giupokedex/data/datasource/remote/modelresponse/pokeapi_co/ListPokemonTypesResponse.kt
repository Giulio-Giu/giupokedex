package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypeDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypesPokemonResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListPokemonTypesResponse(
    var type: TypesPokemonResponse? = null,
) : Parcelable
