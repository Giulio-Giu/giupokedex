package com.example.giupokedex.common.di

import android.app.Application
import android.content.Context
import org.koin.android.ext.android.getKoin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class DIPokedexManager {
    fun initPokedexDependencyInjection(context: Application) {
        try {
            context.getKoin()
        } catch (e: Exception) {
            startKoin(KoinApplication.init())
        } finally {
            context.getKoin().apply {
                /** Application Modules */
                loadModules(
                    listOf(
                        module {
                            single<Context> { context } bind Application::class
                        }
                    )
                )

                /** Data Modules */
                loadModules(DIDataModule().getRepositoryModules())
                loadModules(DIDataModule().getDataSourceModules())
                loadModules(DIDataModule().getServiceModules())

                /** Domain Modules */
                loadModules(DIDomainModules().getDomainModules())

                /** ViewModel Modules */
                loadModules(DIViewModelModules().getViewModelModules())
            }
        }
    }
}