package com.example.inventa_app.utils

import com.example.inventa_app.database.DatabaseRepository
import com.example.inventa_app.database.ItemDatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
lateinit var REPOSITORY:DatabaseRepository
lateinit var ITEM_REPOSITORY:ItemDatabaseRepository