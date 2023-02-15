package com.example.inventa_app.database


import androidx.lifecycle.LiveData
import com.example.inventa_app.model.ItemDataModel

interface ItemDatabaseRepository {
        val readAll: LiveData<List<ItemDataModel>>

        suspend fun create(item:ItemDataModel, onSuccess:()-> Unit)

        suspend fun update(item:ItemDataModel, onSuccess:()-> Unit)

        suspend fun delete(item:ItemDataModel, onSuccess:()-> Unit)
}