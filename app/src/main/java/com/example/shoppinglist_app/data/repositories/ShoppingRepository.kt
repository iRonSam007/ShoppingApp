package com.example.shoppinglist_app.data.repositories

import com.example.shoppinglist_app.data.db.ShoppingDatabase
import com.example.shoppinglist_app.data.db.entities.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase){
    suspend fun insert(item: ShoppingItem){
        db.getShoppingDao().insert(item)
    }

    suspend fun delete(item: ShoppingItem){
        db.getShoppingDao().delete(item)
    }

    suspend fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}