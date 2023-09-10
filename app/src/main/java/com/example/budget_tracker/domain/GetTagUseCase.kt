package com.example.budget_tracker.domain

import com.example.budget_tracker.Db.Tags_Impl

class GetTagUseCase(private val tagsImpl: Tags_Impl) {
    suspend fun gettags()=tagsImpl.getTag()
}