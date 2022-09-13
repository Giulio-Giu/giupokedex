package com.example.giupokedex.data.repository

import com.example.giupokedex.data.datasource.mappers.base.toStatDetailDomainModel
import com.example.giupokedex.data.datasource.mappers.base.toTypeDetailDomainModel
import com.example.giupokedex.data.datasource.mappers.toAbilityDetailDomainModel
import com.example.giupokedex.data.datasource.mappers.toPokemonDomainModel
import com.example.giupokedex.data.datasource.remote.abs.PokedexRemoteDataSource
import com.example.giupokedex.domain.models.Pokemon
import com.example.giupokedex.domain.models.base.AbilityDetail
import com.example.giupokedex.domain.models.base.StatDetail
import com.example.giupokedex.domain.models.base.TypeDetail
import com.example.giupokedex.domain.repository.PokedexRepository

class PokedexRepositoryImpl(
    private val pokedexRemoteDataSource: PokedexRemoteDataSource
) : PokedexRepository {
    override suspend fun getPokemon(idOrName: String): Pokemon {
        return pokedexRemoteDataSource.getPokemon(idOrName).toPokemonDomainModel()
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