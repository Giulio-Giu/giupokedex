package com.example.giupokedex.domain.di

import com.example.giupokedex.domain.usecases.abs.PokedexUseCase
import com.example.giupokedex.domain.usecases.impl.PokedexUseCaseImpl
import org.koin.dsl.module

fun getPokedexDomainModules() = module {
    factory<PokedexUseCase> {
        PokedexUseCaseImpl(pokedexRepository = get())
    }
}