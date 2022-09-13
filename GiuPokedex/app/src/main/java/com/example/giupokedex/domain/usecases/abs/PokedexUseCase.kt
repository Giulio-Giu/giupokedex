package com.example.giupokedex.domain.usecases.abs

import com.example.giupokedex.domain.models.Pokemon
import com.example.giupokedex.domain.models.base.AbilityDetail
import com.example.giupokedex.domain.models.base.StatDetail
import com.example.giupokedex.domain.models.base.TypeDetail

interface PokedexUseCase {
    suspend fun invokePokemon(idOrName: String): Pokemon

    suspend fun invokeAbilityDetail(id: String): AbilityDetail

    suspend fun invokeStatDetail(id: String): StatDetail

    suspend fun invokeTypeDetail(id: String): TypeDetail
}