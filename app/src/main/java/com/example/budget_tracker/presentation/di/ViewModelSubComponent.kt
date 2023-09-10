package com.example.budget_tracker.presentation.di

import com.example.budget_tracker.MainActivity
import dagger.Subcomponent
@ViewModelscope
@Subcomponent(modules =[ViewModelModule::class] )
interface ViewModelSubComponent {
    fun inject(mainActivity:MainActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create():ViewModelSubComponent
    }
}