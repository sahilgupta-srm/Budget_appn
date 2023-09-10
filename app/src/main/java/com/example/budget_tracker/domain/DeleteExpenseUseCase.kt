package com.example.budget_tracker.domain

import com.example.budget_tracker.Db.Expense_Impl

class DeleteExpenseUseCase(private val expenseImpl: Expense_Impl) {
    suspend fun deleteexpense(a:Int)=expenseImpl.deleteById(a)
}