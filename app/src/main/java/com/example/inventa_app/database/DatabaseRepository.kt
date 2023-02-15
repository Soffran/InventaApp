package com.example.inventa_app.database

import androidx.lifecycle.LiveData
import com.example.inventa_app.model.Postman

interface DatabaseRepository {
     val readAll: LiveData<List<Postman>>

     suspend fun create(postman: Postman, onSuccess:()-> Unit)

     suspend fun update(postman: Postman, onSuccess:()-> Unit)

     suspend fun delete(postman: Postman, onSuccess:()-> Unit)

}