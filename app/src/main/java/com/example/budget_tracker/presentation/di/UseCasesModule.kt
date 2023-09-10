package com.example.budget_tracker.presentation.di

import com.example.budget_tracker.Db.Expense_Impl
import com.example.budget_tracker.Db.Tags_Impl
import com.example.budget_tracker.domain.*
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun providesGetExpenseUseCase(expenseImpl: Expense_Impl):GetExpenseUseCase= GetExpenseUseCase(expenseImpl)
    @Provides
    fun providesGetTagUseCase(tagsImpl: Tags_Impl):GetTagUseCase= GetTagUseCase(tagsImpl)
    @Provides
    fun providesSaveTagUseCase(tagsImpl: Tags_Impl):SaveTagUseCase=SaveTagUseCase(tagsImpl)
    @Provides
    fun providesSaveExpense(expenseImpl: Expense_Impl):SaveExpenseUseCase= SaveExpenseUseCase(expenseImpl)
    @Provides
    fun providesdeleteTagUseCase(tagsImpl: Tags_Impl):DeleteTagUseCase= DeleteTagUseCase(tagsImpl)
    @Provides
    fun providesdeleteexpenseUseCasse(expenseImpl: Expense_Impl):DeleteExpenseUseCase=DeleteExpenseUseCase(expenseImpl)


}