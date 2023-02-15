package com.example.inventa_app.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.inventa_app.model.Postman


@Dao
interface PostRoomDao {
    @Query("SELECT * FROM postman_table")
    fun getAllPosts():LiveData<List<Postman>>

    @Insert
    suspend fun addPostman(postman: Postman)

    @Update
    suspend fun updatePostman(postman: Postman)

    @Delete
    suspend fun  deletePostman(postman: Postman)

}