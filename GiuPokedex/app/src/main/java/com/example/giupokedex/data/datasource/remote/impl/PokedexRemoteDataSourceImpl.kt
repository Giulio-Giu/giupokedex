package com.example.giupokedex.data.datasource.remote.impl

import com.example.giupokedex.common.utils.GiuPokedexUtils
import com.example.giupokedex.data.datasource.remote.abs.PokedexRemoteDataSource
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.ListPokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.AbilityDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.StatDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.detail.TypeDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.pokemon.PokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_glitch.GlitchPokemonResponse
import com.example.giupokedex.data.service.abs.PokedexApi
import com.example.giupokedex.data.service.abs.PokedexGlitchApi

class PokedexRemoteDataSourceImpl(
    private val servicePokedexApi: PokedexApi,
    private val servicePokedexGlitchApi: PokedexGlitchApi,
) : PokedexRemoteDataSource {

    override suspend fun getPokemonList(page: Int, offset: Int): ListPokemonResponse {
        val response = servicePokedexApi.getPokemonList(limit = offset, offset = page * offset)
        val body = response.body()

        return if (response.isSuccessful && body != null) {
            body
        } else {
            GiuPokedexUtils.showCustomDialogError()
            ListPokemonResponse()
        }
    }

    override suspend fun getPokemon(idOrName: String): PokemonResponse {
        val response = servicePokedexApi.getPokemon(idOrName)
        val body = response.body()

        return if (response.isSuccessful && body != null) {
            body
        } else {
            GiuPokedexUtils.showCustomDialogError()
            PokemonResponse()
        }
    }

    override suspend fun getGlitchPokemon(idOrName: String): List<GlitchPokemonResponse> {
        val response = servicePokedexGlitchApi.getGlitchPokemon(idOrName)
        val body = response.body()

        return if (response.isSuccessful && body != null) {
            body
        } else {
            GiuPokedexUtils.showCustomDialogError()
            emptyList()
        }
    }

    override suspend fun getAbilityDetail(id: String): AbilityDetailResponse {
        val response = servicePokedexApi.getAbilityDetail(id)
        val body = response.body()

        return if (response.isSuccessful && body != null) {
            body
        } else {
            GiuPokedexUtils.showCustomDialogError()
            AbilityDetailResponse()
        }
    }

    override suspend fun getStatDetail(id: String): StatDetailResponse {
        val response = servicePokedexApi.getStatDetail(id)
        val body = response.body()

        return if (response.isSuccessful && body != null) {
            body
        } else {
            GiuPokedexUtils.showCustomDialogError()
            StatDetailResponse()
        }
    }

    override suspend fun getTypeDetail(id: String): TypeDetailResponse {
        val response = servicePokedexApi.getTypeDetail(id)
        val body = response.body()

        return if (response.isSuccessful && body != null) {
            body
        } else {
            GiuPokedexUtils.showCustomDialogError()
            TypeDetailResponse()
        }
    }
}