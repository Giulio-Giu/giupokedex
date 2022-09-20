package com.example.giupokedex.data.service.di

import com.example.giupokedex.common.utils.service.ServicePokeCoApi
import com.example.giupokedex.common.utils.service.ServicePokeGlitchApi
import com.example.giupokedex.data.service.abs.PokedexApi
import com.example.giupokedex.data.service.abs.PokedexGlitchApi
import org.koin.dsl.module

fun getPokedexServiceModules() = module {
    factory {
        ServicePokeCoApi().createServiceCo(PokedexApi::class.java)
    }
}

fun getPokedexGlitchServiceModules() = module {
    factory {
        ServicePokeGlitchApi().createServiceGlitch(PokedexGlitchApi::class.java)
    }
}

