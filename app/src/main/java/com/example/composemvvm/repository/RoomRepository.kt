package com.example.composemvvm.repository

import com.example.composemvvm.data.local.dao.ItemDao
import com.example.composemvvm.data.local.entities.ItemEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Repository to interact with Room database.
 */
class RoomRepository @Inject constructor(
    private val itemDao: ItemDao
) {
    fun getAllItems(): Flow<List<ItemEntity>> = itemDao.getAllItems()

    suspend fun insertItem(item: ItemEntity) {
        itemDao.insertItem(item)
    }
}
