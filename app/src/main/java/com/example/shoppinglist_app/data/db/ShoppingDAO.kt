package com.example.shoppinglist_app.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppinglist_app.data.db.entities.ShoppingItem


@Dao
interface ShoppingDAO {
    //NB: SQL doen't allow writing to DB in the same thread, hence the asynchronous call of the following fun and the usage of coroutine and suspend functions
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query(value = "SELECT * FROM shopping_items")
    suspend fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}