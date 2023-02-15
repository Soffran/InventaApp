package com.example.inventa_app.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "postman_table")
data class Postman(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0 ,
    @ColumnInfo
    val Title:String
)
