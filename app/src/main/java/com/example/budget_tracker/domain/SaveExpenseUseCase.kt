package com.example.budget_tracker.domain

import com.example.budget_tracker.Db.Expense
import com.example.budget_tracker.Db.Expense_Impl

class SaveExpenseUseCase(private val expenseimpl:Expense_Impl) {
    suspend fun saveExpense(expense: Expense)=expenseimpl.saveExpense(expense)
}