package com.example.composemvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composemvvm.data.local.dao.ItemDao
import com.example.composemvvm.data.local.entities.ItemEntity

/**
 * The Room database class for the app.
 * It provides DAOs and handles database creation and version management.
 */
@Database(entities = [ItemEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}
