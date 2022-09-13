package com.example.giupokedex.domain.usecases.impl

import com.example.giupokedex.domain.models.Pokemon
import com.example.giupokedex.domain.models.base.AbilityDetail
import com.example.giupokedex.domain.models.base.StatDetail
import com.example.giupokedex.domain.models.base.TypeDetail
import com.example.giupokedex.domain.repository.PokedexRepository
import com.example.giupokedex.domain.usecases.abs.PokedexUseCase

class PokedexUseCaseImpl(
    private val pokedexRepository: PokedexRepository
) : PokedexUseCase {
    override suspend fun invokePokemon(idOrName: String): Pokemon {
        return pokedexRepository.getPokemon(idOrName)
    }

    override suspend fun invokeAbilityDetail(id: String): AbilityDetail {
        return pokedexRepository.getAbilityDetail(id)
    }

    override suspend fun invokeStatDetail(id: String): StatDetail {
        return pokedexRepository.getStatDetail(id)
    }

    override suspend fun invokeTypeDetail(id: String): TypeDetail {
        return pokedexRepository.getTypeDetail(id)
    }
}