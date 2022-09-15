package com.example.giupokedex.data.service.abs

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_glitch.GlitchPokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexGlitchApi {
    @GET("pokemon/{idOrName}")
    suspend fun getGlitchPokemon(
        @Path("idOrName") idOrName: String,
    ): GlitchPokemonResponse
}