package com.example.budget_tracker.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents=[ViewModelSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun providesApplicationContext():Context=context.applicationContext
}