package com.example.budget_tracker.Db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpenseDao {
    @Insert()
    suspend fun saveExpense(expense: Expense)

    @Query("SELECT * FROM Amount_data")
    suspend fun getData():List<Expense>

    @Query("DELETE FROM Amount_data WHERE Id= :a")
    suspend fun deleteById(a:Int)
}