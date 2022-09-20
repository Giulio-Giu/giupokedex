package com.example.giupokedex.common.di

import com.example.giupokedex.presentation.di.getHomeViewModelModules

class DIViewModelModules {
    fun getViewModelModules() = listOf(
        getHomeViewModelModules()
    )
}