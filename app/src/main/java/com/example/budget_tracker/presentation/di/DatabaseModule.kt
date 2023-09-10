package com.example.budget_tracker.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.budget_tracker.Db.DataClass
import com.example.budget_tracker.Db.ExpenseDao
import com.example.budget_tracker.Db.TagsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideExpenseDataBase(context: Context):DataClass{
        return Room.databaseBuilder(context,DataClass::class.java,"Expense").build()
    }
    @Provides
    @Singleton
    fun provideTagDao(dataClass: DataClass):TagsDao=dataClass.tagsDao()
    @Provides
    @Singleton
    fun providesexpenseDao(dataClass: DataClass):ExpenseDao=dataClass.expenseDao()


}