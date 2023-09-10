package com.example.budget_tracker.presentation.di

import com.example.budget_tracker.domain.*
import com.example.budget_tracker.presentation.MainActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @ViewModelscope
    @Provides
    fun provideViewModelFactory(
         getTagUseCase: GetTagUseCase,
          getExpenseUseCase: GetExpenseUseCase,
          saveExpenseUseCase: SaveExpenseUseCase,
         saveTagUseCase: SaveTagUseCase,
          deleteTagUseCase: DeleteTagUseCase,
          deleteExpenseUseCase: DeleteExpenseUseCase
    ):MainActivityViewModelFactory= MainActivityViewModelFactory(getTagUseCase, getExpenseUseCase, saveExpenseUseCase, saveTagUseCase, deleteTagUseCase, deleteExpenseUseCase)
}