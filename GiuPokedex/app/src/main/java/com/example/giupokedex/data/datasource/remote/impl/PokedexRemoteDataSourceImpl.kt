package com.example.giupokedex.data.datasource.remote.impl

import com.example.giupokedex.data.datasource.remote.abs.PokedexRemoteDataSource
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon.PokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.AbilityDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.StatDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.TypeDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_glitch.GlitchPokemonResponse
import com.example.giupokedex.data.service.abs.PokedexApi
import com.example.giupokedex.data.service.abs.PokedexGlitchApi

class PokedexRemoteDataSourceImpl(
    private val servicePokedexApi: PokedexApi,
    private val servicePokedexGlitchApi: PokedexGlitchApi,
) : PokedexRemoteDataSource {

    override suspend fun getPokemon(idOrName: String): PokemonResponse {
        return try {
            servicePokedexApi.getPokemon(idOrName)
        } catch (e: Exception) {
            PokemonResponse()
        }
    }

    override suspend fun getGlitchPokemon(idOrName: String): List<GlitchPokemonResponse> {
        return try {
            servicePokedexGlitchApi.getGlitchPokemon(idOrName)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getAbilityDetail(id: String): AbilityDetailResponse {
        return try {
            servicePokedexApi.getAbilityDetail(id)
        } catch (e: Exception) {
            AbilityDetailResponse()
        }
    }

    override suspend fun getStatDetail(id: String): StatDetailResponse {
        return try {
            servicePokedexApi.getStatDetail(id)
        } catch (e: Exception) {
            StatDetailResponse()
        }
    }

    override suspend fun getTypeDetail(id: String): TypeDetailResponse {
        return try {
            servicePokedexApi.getTypeDetail(id)
        } catch (e: Exception) {
            TypeDetailResponse()
        }
    }
}