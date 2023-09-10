package com.example.budget_tracker.Db

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Tags_Impl(private val tagsDao: TagsDao):Tags_interface {
    override suspend fun getTag(): List<Tags> {
         return tagsDao.gettag()
    }

    override suspend fun saveTag(tag: Tags) {
        CoroutineScope(Dispatchers.IO).launch {
            tagsDao.saveTag(tag)
        }
    }

    override suspend fun deleteByTag(a: String) {
        CoroutineScope(Dispatchers.IO).launch {
            tagsDao.deleteByTag(a)
        }
    }
}