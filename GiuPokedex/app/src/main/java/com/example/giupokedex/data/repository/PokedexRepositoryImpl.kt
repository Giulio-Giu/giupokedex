package com.example.giupokedex.data.repository

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toStatDetailDomainModel
import com.example.giupokedex.data.datasource.mappers.pokeapi_co.detail.toTypeDetailDomainModel
import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toAbilityDetailDomainModel
import com.example.giupokedex.data.datasource.mappers.pokeapi_co.pokemon.toPokemonDomainModel
import com.example.giupokedex.data.datasource.mappers.pokeapi_glitch.toListGlitchPokemonDomainModel
import com.example.giupokedex.data.datasource.remote.abs.PokedexRemoteDataSource
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.Pokemon
import com.example.giupokedex.domain.models.pokeapi_co.detail.AbilityDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.StatDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.TypeDetail
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon
import com.example.giupokedex.domain.repository.PokedexRepository

class PokedexRepositoryImpl(
    private val pokedexRemoteDataSource: PokedexRemoteDataSource
) : PokedexRepository {
    override suspend fun getPokemonCo(idOrName: String): Pokemon {
        return pokedexRemoteDataSource.getPokemon(idOrName).toPokemonDomainModel()
    }

    override suspend fun getGlitchPokemon(idOrName: String): List<GlitchPokemon> {
        return pokedexRemoteDataSource.getGlitchPokemon(idOrName).toListGlitchPokemonDomainModel()
    }

    override suspend fun getAbilityDetail(id: String): AbilityDetail {
        return pokedexRemoteDataSource.getAbilityDetail(id).toAbilityDetailDomainModel()
    }

    override suspend fun getStatDetail(id: String): StatDetail {
        return pokedexRemoteDataSource.getStatDetail(id).toStatDetailDomainModel()
    }

    override suspend fun getTypeDetail(id: String): TypeDetail {
        return pokedexRemoteDataSource.getTypeDetail(id).toTypeDetailDomainModel()
    }
}