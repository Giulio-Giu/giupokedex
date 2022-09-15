package com.example.giupokedex.common.di

import com.example.giupokedex.data.datasource.remote.di.getPokedexDataSourceModules
import com.example.giupokedex.data.di.getPokedexDataModules
import com.example.giupokedex.data.service.di.getPokedexGlitchServiceModules
import com.example.giupokedex.data.service.di.getPokedexServiceModules

class DIDataModule {

    fun getRepositoryModules() = listOf(
        getPokedexDataModules()
    )

    fun getDataSourceModules() = listOf(
        getPokedexDataSourceModules()
    )

    fun getServiceModules() = listOf(
        getPokedexServiceModules(),
        getPokedexGlitchServiceModules(),
    )
}