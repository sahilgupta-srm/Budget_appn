package com.example.budget_tracker.presentation.di

import android.app.Application

class App:Application(),Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent=DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    override fun createviewModelSubComponent(): ViewModelSubComponent {
        return appComponent.viewmodelSubComponent().create()
    }
}