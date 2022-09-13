package com.example.giupokedex.presentation.di

import com.example.giupokedex.presentation.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getMainViewModelModules() = module {
    viewModel {
        MainViewModel(pokedexUseCase = get())
    }
}