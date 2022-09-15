package com.example.giupokedex.data.service.abs

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.PokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.AbilityDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.StatDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypeDetailResponse
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