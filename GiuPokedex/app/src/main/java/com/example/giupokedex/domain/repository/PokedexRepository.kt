package com.example.giupokedex.domain.repository

import com.example.giupokedex.domain.models.Pokemon
import com.example.giupokedex.domain.models.base.AbilityDetail
import com.example.giupokedex.domain.models.base.StatDetail
import com.example.giupokedex.domain.models.base.TypeDetail

interface PokedexRepository {
    suspend fun getPokemon(idOrName: String): Pokemon
    suspend fun getAbilityDetail(id: String): AbilityDetail
    suspend fun getStatDetail(id: String): StatDetail
    suspend fun getTypeDetail(id: String): TypeDetail
}