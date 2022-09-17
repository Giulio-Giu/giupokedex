package com.example.giupokedex.data.datasource.mappers.pokeapi_glitch

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_glitch.GlitchPokemonResponse
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemonFamily

fun List<GlitchPokemonResponse>.toListGlitchPokemonDomainModel() = mapNotNull {
    try {
        it.toGlitchPokemonDomainModel()
    } catch (e: Exception) {
        GlitchPokemon()
    }
}

fun GlitchPokemonResponse.toGlitchPokemonDomainModel() = GlitchPokemon(
    number = number ?: 0,
    name = name.orEmpty(),
    species = species.orEmpty(),
    description = description.orEmpty(),
    family = family?.toGlitchPokemonFamilyDomainModel() ?: GlitchPokemonFamily(),
    image = sprite.orEmpty(),
    is_starter = starter ?: false,
    is_legendary = legendary ?: false,
    is_mythical = mythical ?: false,
    is_ultraBeast = ultraBeast ?: false,
    is_mega = mega ?: false,
)