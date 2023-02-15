package com.example.inventa_app.database.room.repository

import androidx.lifecycle.LiveData
import com.example.inventa_app.database.DatabaseRepository
import com.example.inventa_app.database.room.dao.PostRoomDao
import com.example.inventa_app.model.Postman

class RoomRepository(private val postRoomDao: PostRoomDao): DatabaseRepository {
    override val readAll: LiveData<List<Postman>>
        get() = postRoomDao.getAllPosts()

    override suspend fun create(postman: Postman, onSuccess: () -> Unit) {
        postRoomDao.addPostman(postman = postman)
        onSuccess()
    }

    override suspend fun update(postman: Postman, onSuccess: () -> Unit) {
        postRoomDao.updatePostman(postman = postman)
        onSuccess()
    }

    override suspend fun delete(postman: Postman, onSuccess: () -> Unit) {
        postRoomDao.deletePostman(postman = postman)
        onSuccess()
    }
}