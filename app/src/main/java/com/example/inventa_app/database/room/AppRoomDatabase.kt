package com.example.inventa_app.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.inventa_app.database.room.dao.PostRoomDao
import com.example.inventa_app.model.Postman


@Database(entities = [Postman::class], version = 1)
abstract class AppRoomDatabase:RoomDatabase() {
    abstract fun getRoomDao(): PostRoomDao

    companion object{
        @Volatile
        private var INSTANCE:AppRoomDatabase? = null

        fun getInstance (context: Context):AppRoomDatabase {
            return  if ( INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "Postman_databasee"
                ).build()
                INSTANCE as AppRoomDatabase
            }
            else INSTANCE as AppRoomDatabase
        }
    }
}