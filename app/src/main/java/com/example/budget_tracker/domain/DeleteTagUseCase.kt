package com.example.budget_tracker.domain

import com.example.budget_tracker.Db.Tags_Impl

class DeleteTagUseCase (private val tagsImpl: Tags_Impl){
    suspend fun deleteTag(a:String)=tagsImpl.deleteByTag(a)
}