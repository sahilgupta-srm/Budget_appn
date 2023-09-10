package com.example.budget_tracker.domain

import com.example.budget_tracker.Db.Expense_Impl

class GetExpenseUseCase(private val expenseImpl: Expense_Impl) {
    suspend fun getExpenses()=expenseImpl.getData()
}