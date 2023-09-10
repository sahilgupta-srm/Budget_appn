package com.example.budget_tracker.presentation.di

import com.example.budget_tracker.Db.ExpenseDao
import com.example.budget_tracker.Db.Expense_Impl
import com.example.budget_tracker.Db.TagsDao
import com.example.budget_tracker.Db.Tags_Impl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImplModule {
    @Provides
    @Singleton
    fun providestagsImpl(tagsDao: TagsDao):Tags_Impl=Tags_Impl(tagsDao)

    @Provides
    @Singleton
    fun providesexpenseImpl(expenseDao: ExpenseDao):Expense_Impl=Expense_Impl(expenseDao)
}