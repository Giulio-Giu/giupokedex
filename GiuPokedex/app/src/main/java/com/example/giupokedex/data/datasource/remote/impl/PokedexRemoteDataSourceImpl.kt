package com.example.giupokedex.data.datasource.remote.impl

import com.example.giupokedex.data.datasource.remote.abs.PokedexRemoteDataSource
import com.example.giupokedex.data.datasource.remote.modelresponse.PokemonResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.base.AbilityDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.base.StatDetailResponse
import com.example.giupokedex.data.datasource.remote.modelresponse.base.TypeDetailResponse
import com.example.giupokedex.data.service.abs.PokedexApi

class PokedexRemoteDataSourceImpl (
    private val servicePokedexApi: PokedexApi
        ) : PokedexRemoteDataSource {

    override suspend fun getPokemon(idOrName: String): PokemonResponse {
        return try {
            servicePokedexApi.getPokemon(idOrName)
        } catch (e: Exception) {
            PokemonResponse()
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