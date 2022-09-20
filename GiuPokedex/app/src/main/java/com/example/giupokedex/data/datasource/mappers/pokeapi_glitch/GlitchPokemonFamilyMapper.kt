package com.example.giupokedex.data.datasource.mappers.pokeapi_glitch

import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_glitch.GlitchPokemonFamilyResponse
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemonFamily

fun GlitchPokemonFamilyResponse.toGlitchPokemonFamilyDomainModel() = GlitchPokemonFamily(
    id = id ?: 0,
    evolutionStage = evolutionStage ?: 0,
    evolutionLine = evolutionLine.orEmpty(),
)