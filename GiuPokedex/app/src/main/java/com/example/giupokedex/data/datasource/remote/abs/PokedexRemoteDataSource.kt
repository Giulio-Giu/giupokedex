package com.example.giupokedex.data.datasource.remote.abs

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.PokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.AbilityDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.StatDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.TypeDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_glitch.GlitchPokemonResponse

interface PokedexRemoteDataSource {
    suspend fun getPokemon(idOrName: String) : PokemonResponse
    suspend fun getGlitchPokemon(idOrName: String) : GlitchPokemonResponse
    suspend fun getAbilityDetail(id: String) : AbilityDetailResponse
    suspend fun getStatDetail(id: String) : StatDetailResponse
    suspend fun getTypeDetail(id: String) : TypeDetailResponse
}