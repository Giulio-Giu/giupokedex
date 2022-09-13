package com.example.giupokedex.common.di

import com.example.giupokedex.domain.di.getPokedexDomainModules

class DIDomainModules {
    fun getDomainModules() = listOf(
        getPokedexDomainModules()
    )
}