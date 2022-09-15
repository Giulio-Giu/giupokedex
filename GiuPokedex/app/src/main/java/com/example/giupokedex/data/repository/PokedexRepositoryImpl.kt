package com.example.giupokedex.data.repository

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toStatDetailDomainModel
import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toTypeDetailDomainModel
import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.toAbilityDetailDomainModel
import com.example.giupokedex.data.datasource.mappers.pokeapi_glitch.toGlitchPokemonDomainModel
import com.example.giupokedex.data.datasource.mappers.toPokemonDomainModel
import com.example.giupokedex.data.datasource.remote.abs.PokedexRemoteDataSource
import com.example.giupokedex.domain.models.pokeapi_co.Pokemon
import com.example.giupokedex.domain.models.pokeapi_co.base.AbilityDetail
import com.example.giupokedex.domain.models.pokeapi_co.base.StatDetail
import com.example.giupokedex.domain.models.pokeapi_co.base.TypeDetail
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon
import com.example.giupokedex.domain.repository.PokedexRepository

class PokedexRepositoryImpl(
    private val pokedexRemoteDataSource: PokedexRemoteDataSource
) : PokedexRepository {
    override suspend fun getPokemonCo(idOrName: String): Pokemon {
        return pokedexRemoteDataSource.getPokemon(idOrName).toPokemonDomainModel()
    }

    override suspend fun getGlitchPokemon(idOrName: String): GlitchPokemon {
        return pokedexRemoteDataSource.getGlitchPokemon(idOrName).toGlitchPokemonDomainModel()
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