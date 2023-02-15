package com.example.inventa_app.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.inventa_app.database.room.dao.ItemRoomDao
import com.example.inventa_app.model.ItemDataModel

@Database(entities = [ItemDataModel::class], version = 1)
abstract class ItemRoomDatabase: RoomDatabase() {
    abstract fun getRoomDao(): ItemRoomDao

    companion object{
        @Volatile
        private var INSTANCE:ItemRoomDatabase? = null

        fun getInstance (context: Context):ItemRoomDatabase {
            return  if ( INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    ItemRoomDatabase::class.java,
                    "Item_databasee"
                ).build()
                INSTANCE as ItemRoomDatabase
            }
            else INSTANCE as ItemRoomDatabase
        }
    }
}