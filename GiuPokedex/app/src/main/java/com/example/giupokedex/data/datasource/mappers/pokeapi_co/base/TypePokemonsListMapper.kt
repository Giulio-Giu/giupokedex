package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypePokemonsListResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.TypePokemon
import com.example.giupokedex.domain.models.pokeapi_co.base.TypePokemonsList

fun List<TypePokemonsListResponse>.toListTypePokemonsListDomainModel() = mapNotNull {
    try {
        it.toTypePokemonsListDomainModel()
    } catch (e: Exception) {
        null
    }
}

fun TypePokemonsListResponse.toTypePokemonsListDomainModel() = TypePokemonsList(
    pokemon = pokemon?.toTypePokemonDomainModel() ?: TypePokemon(),
)