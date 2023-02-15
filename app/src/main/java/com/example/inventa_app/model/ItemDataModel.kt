package com.example.inventa_app.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Item_table")
data class ItemDataModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0 ,
    @ColumnInfo
    val Title:String,
    @ColumnInfo
    val FullTitle:String,
    @ColumnInfo
    val EdIzmer:String,
    @ColumnInfo
    val PostmanFor:String? =null,
    @ColumnInfo
    val Kategory:String? = null,
    @ColumnInfo
    var Count:Int = 0
)