package com.example.budget_tracker.Db

interface Expense_Interface {
    suspend fun getData():List<Expense>
    suspend fun saveExpense(expense:Expense)
    suspend fun deleteById(a:Int)
}