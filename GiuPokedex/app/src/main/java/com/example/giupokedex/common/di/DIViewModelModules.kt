package com.example.giupokedex.common.di

import com.example.giupokedex.presentation.di.getMainViewModelModules

class DIViewModelModules {
    fun getViewModelModules() = listOf(
        getMainViewModelModules()
    )
}