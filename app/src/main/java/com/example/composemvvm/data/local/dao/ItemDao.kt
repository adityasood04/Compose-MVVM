package com.example.composemvvm.data.local.dao

import androidx.room.*
import com.example.composemvvm.data.local.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO (Data Access Object) for performing operations on the 'items' table.
 * This interface tells Room how to interact with your local database.
 */
@Dao
interface ItemDao {

    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<ItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ItemEntity)

    @Delete
    suspend fun deleteItem(item: ItemEntity)
}
