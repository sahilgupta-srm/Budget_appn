package com.example.budget_tracker.Db

interface Tags_interface {
    suspend fun getTag():List<Tags>
    suspend fun saveTag(tag:Tags)
    suspend fun deleteByTag(a:String)
}