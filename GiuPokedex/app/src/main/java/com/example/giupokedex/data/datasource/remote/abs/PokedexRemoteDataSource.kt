package com.example.giupokedex.data.datasource.remote.abs

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon.PokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.AbilityDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.StatDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.TypeDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_glitch.GlitchPokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.ListPokemonResponse

interface PokedexRemoteDataSource {
    suspend fun getPokemonList(page: Int, offset: Int) : ListPokemonResponse
    suspend fun getPokemon(idOrName: String) : PokemonResponse
    suspend fun getGlitchPokemon(idOrName: String) : List<GlitchPokemonResponse>
    suspend fun getAbilityDetail(id: String) : AbilityDetailResponse
    suspend fun getStatDetail(id: String) : StatDetailResponse
    suspend fun getTypeDetail(id: String) : TypeDetailResponse
}