package com.example.giupokedex.data.service.abs

import com.example.giupokedex.data.datasource.remote.modelresponse.PokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.base.AbilityDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.base.StatDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.base.TypeDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApi {

    @GET("pokemon/{idOrName}")
    suspend fun getPokemon(
        @Path("idOrName") idOrName: String,
    ): PokemonResponse

    @GET("ability/{id}")
    suspend fun getAbilityDetail(
        @Path("id") id: String,
    ): AbilityDetailResponse

    @GET("stat/{id}")
    suspend fun getStatDetail(
        @Path("id") id: String,
    ): StatDetailResponse

    @GET("type/{id}")
    suspend fun getTypeDetail(
        @Path("id") id: String,
    ): TypeDetailResponse
}