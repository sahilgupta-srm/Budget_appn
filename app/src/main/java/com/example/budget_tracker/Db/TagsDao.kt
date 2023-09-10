package com.example.budget_tracker.Db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TagsDao {
    @Insert( onConflict =OnConflictStrategy.IGNORE)
    suspend fun saveTag(tag:Tags)

    @Query("SELECT * FROM User_tags")
    suspend fun gettag():List<Tags>

    @Query("DELETE FROM User_tags WHERE Name = :a")
    suspend fun deleteByTag(a: String)

}