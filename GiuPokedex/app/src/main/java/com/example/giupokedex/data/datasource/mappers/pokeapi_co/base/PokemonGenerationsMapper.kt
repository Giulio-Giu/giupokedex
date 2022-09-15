package com.example.giupokedex.data.datasource.mappers.pokeapi_co.base

import com.example.giupokedex.data.datasource.mappers.pokeapi_co.base.generations.*
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.PokemonGenerationsResponse
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonGenerations
import com.example.giupokedex.domain.models.pokeapi_co.base.genarations.*

fun PokemonGenerationsResponse.toPokemonGenerationsDomainModel() = PokemonGenerations(
    generation_1 = generation_1?.toGeneration1DomainModel() ?: Generation1(),
    generation_2 = generation_2?.toGeneration2DomainModel() ?: Generation2(),
    generation_3 = generation_3?.toGeneration3DomainModel() ?: Generation3(),
    generation_4 = generation_4?.toGeneration4DomainModel() ?: Generation4(),
    generation_5 = generation_5?.toGeneration5DomainModel() ?: Generation5(),
    generation_6 = generation_6?.toGeneration6DomainModel() ?: Generation6(),
    generation_7 = generation_7?.toGeneration7DomainModel() ?: Generation7(),
    generation_8 = generation_8?.toGeneration8DomainModel() ?: Generation8(),
)