package com.example.giupokedex.domain.usecases.abs

import com.example.giupokedex.domain.models.pokeapi_co.ListPokemon
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.Pokemon
import com.example.giupokedex.domain.models.pokeapi_co.detail.AbilityDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.StatDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.TypeDetail
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon

interface PokedexUseCase {
    suspend fun invokeListPokemon(page: Int, offset: Int): ListPokemon

    suspend fun invokePokemon(idOrName: String): Pokemon

    suspend fun invokeGlitchPokemon(idOrName: String): List<GlitchPokemon>

    suspend fun invokeAbilityDetail(id: String): AbilityDetail

    suspend fun invokeStatDetail(id: String): StatDetail

    suspend fun invokeTypeDetail(id: String): TypeDetail
}