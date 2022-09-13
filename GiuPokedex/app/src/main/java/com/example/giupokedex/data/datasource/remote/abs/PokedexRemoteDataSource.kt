package com.example.giupokedex.data.datasource.remote.abs

import com.example.giupokedex.data.datasource.remote.modelresponse.PokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.base.AbilityDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.base.StatDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.base.TypeDetailResponse

interface PokedexRemoteDataSource {
    suspend fun getPokemon(idOrName: String) : PokemonResponse
    suspend fun getAbilityDetail(id: String) : AbilityDetailResponse
    suspend fun getStatDetail(id: String) : StatDetailResponse
    suspend fun getTypeDetail(id: String) : TypeDetailResponse
}