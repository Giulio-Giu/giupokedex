package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypePokemonsListResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeDetailResponse(
    var id: Int? = null,
    var name: String? = null,
    var pokemon: List<TypePokemonsListResponse>? = null,
) : Parcelable
