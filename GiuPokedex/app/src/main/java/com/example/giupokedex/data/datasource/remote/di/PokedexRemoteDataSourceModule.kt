package com.example.giupokedex.data.datasource.remote.di

import com.example.giupokedex.data.datasource.remote.abs.PokedexRemoteDataSource
import com.example.giupokedex.data.datasource.remote.impl.PokedexRemoteDataSourceImpl
import org.koin.dsl.module

fun getPokedexDataSourceModules() = module {
    factory<PokedexRemoteDataSource> {
        PokedexRemoteDataSourceImpl(servicePokedexApi = get())
    }
}