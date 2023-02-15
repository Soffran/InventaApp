package com.example.inventa_app.database.room.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.inventa_app.model.ItemDataModel

@Dao
interface ItemRoomDao {
    @Query("SELECT * FROM Item_table")
    fun getAllItem(): LiveData<List<ItemDataModel>>

    @Insert
    suspend fun addItem(item: ItemDataModel)

    @Update
    suspend fun updateItem(item: ItemDataModel)

    @Delete
    suspend fun  deleteItem(item: ItemDataModel)

}
