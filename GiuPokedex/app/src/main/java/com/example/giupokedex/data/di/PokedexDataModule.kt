package com.example.giupokedex.data.di

import com.example.giupokedex.data.repository.PokedexRepositoryImpl
import com.example.giupokedex.domain.repository.PokedexRepository
import org.koin.dsl.module

fun getPokedexDataModules() = module {
    factory<PokedexRepository> {
        PokedexRepositoryImpl(pokedexRemoteDataSource = get())
    }
}