package com.example.budget_tracker.Db

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Expense_Impl(private val expenseDao: ExpenseDao):Expense_Interface {
    private val list=ArrayList<Expense>()
    override suspend fun getData(): List<Expense> {
        return expenseDao.getData()

    }

    override suspend fun saveExpense(expense: Expense) {
        CoroutineScope(Dispatchers.IO).launch{
            expenseDao.saveExpense(expense)
        }
    }

    override suspend fun deleteById(a: Int) {
        CoroutineScope(Dispatchers.IO).launch{
            expenseDao.deleteById(a)
        }
    }


}