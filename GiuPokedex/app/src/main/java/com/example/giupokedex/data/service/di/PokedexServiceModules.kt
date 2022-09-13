package com.example.giupokedex.data.service.di

import com.example.giupokedex.common.utils.ServiceApi
import com.example.giupokedex.data.service.abs.PokedexApi
import org.koin.dsl.module

fun getPokedexServiceModules() = module {
    factory { ServiceApi().createService(PokedexApi::class.java) }
}