package com.example.budget_tracker.presentation.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[AppModule::class,DatabaseModule::class,ImplModule::class,UseCasesModule::class])
interface AppComponent {
    fun viewmodelSubComponent():ViewModelSubComponent.Factory
}