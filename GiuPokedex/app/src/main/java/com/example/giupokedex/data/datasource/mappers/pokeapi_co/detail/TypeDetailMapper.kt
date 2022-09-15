package com.example.giupokedex.data.datasource.mappers.pokeapi_co.detail

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toListTypePokemonsListDomainModel
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.TypeDetailResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.TypePokemonsList
import com.example.giupokedex.domain.models.pokeapi_co.detail.TypeDetail

fun TypeDetailResponse.toTypeDetailDomainModel() = TypeDetail(
    id = id ?: 0,
    name = name.orEmpty(),
    listPokemons = listPokemons?.toListTypePokemonsListDomainModel().orEmpty(),
)