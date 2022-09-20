package com.example.giupokedex.presentation.di

import com.example.giupokedex.presentation.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getHomeViewModelModules() = module {
    viewModel {
        HomeViewModel(pokedexUseCase = get())
    }
}