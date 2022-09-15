package com.example.giupokedex.domain.usecases.abs

import com.example.giupokedex.domain.models.pokeapi_co.Pokemon
import com.example.giupokedex.domain.models.pokeapi_co.base.AbilityDetail
import com.example.giupokedex.domain.models.pokeapi_co.base.StatDetail
import com.example.giupokedex.domain.models.pokeapi_co.base.TypeDetail
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon

interface PokedexUseCase {
    suspend fun invokePokemon(idOrName: String): Pokemon

    suspend fun invokeGlitchPokemon(idOrName: String): GlitchPokemon

    suspend fun invokeAbilityDetail(id: String): AbilityDetail

    suspend fun invokeStatDetail(id: String): StatDetail

    suspend fun invokeTypeDetail(id: String): TypeDetail
}