package com.example.giupokedex.data.datasource.mappers.pokeapi_glitch

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_glitch.GlitchPokemonResponse
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemon
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemonFamily

fun GlitchPokemonResponse.toGlitchPokemonDomainModel() = GlitchPokemon(
    number = number ?: 1,
    name = name.orEmpty(),
    specie = name.orEmpty(),
    description = name.orEmpty(),
    family = family?.toGlitchPokemonFamilyDomainModel() ?: GlitchPokemonFamily(),
    starter = starter ?: false,
    legendary = legendary ?: false,
    mythical = mythical ?: false,
    ultraBeast = ultraBeast ?: false,
    mega = mega ?: false,
)