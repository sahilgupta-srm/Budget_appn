package com.example.budget_tracker.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.budget_tracker.domain.*

class MainActivityViewModelFactory(
    private val getTagUseCase: GetTagUseCase,
    private val getExpenseUseCase: GetExpenseUseCase,
    private val saveExpenseUseCase: SaveExpenseUseCase,
    private val saveTagUseCase: SaveTagUseCase,
    private val deleteTagUseCase: DeleteTagUseCase,
    private val deleteExpenseUseCase: DeleteExpenseUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(getTagUseCase, getExpenseUseCase, saveExpenseUseCase, saveTagUseCase, deleteTagUseCase, deleteExpenseUseCase) as T
    }
}