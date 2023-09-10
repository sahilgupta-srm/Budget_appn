package com.example.budget_tracker.domain


import com.example.budget_tracker.Db.Tags
import com.example.budget_tracker.Db.Tags_Impl

class SaveTagUseCase(private val tagsImpl: Tags_Impl) {
    suspend fun savetag(a: Tags)=tagsImpl.saveTag(a)
}