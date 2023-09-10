package com.example.budget_tracker.Db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="User_tags")
data class Tags (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="Id")
    val id:Int,
    @ColumnInfo(name="Name")
    val name:String


)