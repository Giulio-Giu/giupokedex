package com.example.giupokedex.domain.usecases.impl

import com.example.giupokedex.domain.models.pokeapi_co.pokemon.Pokemon
import com.example.giupokedex.domain.models.pokeapi_co.detail.AbilityDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.StatDetail
import com.example.giupokedex.domain.models.pokeapi_co.detail.TypeDetail
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon
import com.example.giupokedex.domain.repository.PokedexRepository
import com.example.giupokedex.domain.usecases.abs.PokedexUseCase

class PokedexUseCaseImpl(
    private val pokedexRepository: PokedexRepository
) : PokedexUseCase {
    override suspend fun invokePokemon(idOrName: String): Pokemon {
        return pokedexRepository.getPokemonCo(idOrName)
    }

    override suspend fun invokeGlitchPokemon(idOrName: String): GlitchPokemon {
        return pokedexRepository.getGlitchPokemon(idOrName)
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