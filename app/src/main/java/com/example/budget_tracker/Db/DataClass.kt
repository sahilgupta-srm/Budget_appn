package com.example.budget_tracker.Db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities=[Tags::class,Expense::class],version=1, exportSchema = false)
abstract class DataClass:RoomDatabase() {
    abstract fun tagsDao():TagsDao
    abstract fun expenseDao():ExpenseDao
}