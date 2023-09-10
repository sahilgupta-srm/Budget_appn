package com.example.budget_tracker.Db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName="Amount_data")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("Id")
    val id:Int,
    @ColumnInfo("Amount")
    val value:Float,
    @ColumnInfo("Date")
    val date: String,
    @ColumnInfo("Tag")
    val a:String

)