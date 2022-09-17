package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.generations.*
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonGenerationsResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonGenerations
import com.example.giupokedex.domain.models.pokeapi_co.base.generations.*

fun PokemonGenerationsResponse.toPokemonGenerationsDomainModel() = PokemonGenerations(
    generation_1 = `generation-i`?.toGeneration1DomainModel() ?: Generation1(),
    generation_2 = `generation-ii`?.toGeneration2DomainModel() ?: Generation2(),
    generation_3 = `generation-iii`?.toGeneration3DomainModel() ?: Generation3(),
    generation_4 = `generation-iv`?.toGeneration4DomainModel() ?: Generation4(),
    generation_5 = `generation-v`?.toGeneration5DomainModel() ?: Generation5(),
    generation_6 = `generation-vi`?.toGeneration6DomainModel() ?: Generation6(),
    generation_7 = `generation-vii`?.toGeneration7DomainModel() ?: Generation7(),
    generation_8 = `generation-viii`?.toGeneration8DomainModel() ?: Generation8(),
)