package com.example.giupokedex.domain.repository

import com.example.giupokedex.domain.models.pokeapi_co.pokemon.Pokemon
import com.example.giupokedex.domain.models.pokeapi_co.detail.AbilityDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.StatDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.TypeDetail
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon

interface PokedexRepository {
    suspend fun getPokemonCo(idOrName: String): Pokemon
    suspend fun getGlitchPokemon(idOrName: String): GlitchPokemon
    suspend fun getAbilityDetail(id: String): AbilityDetail
    suspend fun getStatDetail(id: String): StatDetail
    suspend fun getTypeDetail(id: String): TypeDetail
}