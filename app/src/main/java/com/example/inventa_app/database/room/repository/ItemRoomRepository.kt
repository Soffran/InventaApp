package com.example.inventa_app.database.room.repository

import androidx.lifecycle.LiveData
import com.example.inventa_app.database.ItemDatabaseRepository
import com.example.inventa_app.database.room.dao.ItemRoomDao
import com.example.inventa_app.model.ItemDataModel

class ItemRoomRepository(private val itemRoomDao: ItemRoomDao): ItemDatabaseRepository {
    override val readAll: LiveData<List<ItemDataModel>>
        get() = itemRoomDao.getAllItem()

    override suspend fun create(item:ItemDataModel, onSuccess: () -> Unit) {
        itemRoomDao.addItem(item = item)
        onSuccess()
    }

    override suspend fun update(item:ItemDataModel, onSuccess: () -> Unit) {
        itemRoomDao.updateItem(item = item)
        onSuccess()
    }
    override suspend fun delete(item:ItemDataModel, onSuccess: () -> Unit) {
        itemRoomDao.deleteItem(item = item)
        onSuccess()
    }
}