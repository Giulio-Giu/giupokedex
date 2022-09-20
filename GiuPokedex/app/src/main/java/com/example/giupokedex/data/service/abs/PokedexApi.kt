package com.example.giupokedex.data.service.abs

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon.PokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.AbilityDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.StatDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.TypeDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.ListPokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): Response<ListPokemonResponse>

    @GET("pokemon/{idOrName}")
    suspend fun getPokemon(
        @Path("idOrName") idOrName: String,
    ): Response<PokemonResponse>

    @GET("ability/{id}")
    suspend fun getAbilityDetail(
        @Path("id") id: String,
    ): Response<AbilityDetailResponse>

    @GET("stat/{id}")
    suspend fun getStatDetail(
        @Path("id") id: String,
    ): Response<StatDetailResponse>

    @GET("type/{id}")
    suspend fun getTypeDetail(
        @Path("id") id: String,
    ): Response<TypeDetailResponse>
}