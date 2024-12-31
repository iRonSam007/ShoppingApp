package com.example.shoppinglist_app.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglist_app.data.db.entities.ShoppingItem
import com.example.shoppinglist_app.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repo : ShoppingRepository) : ViewModel() {

    fun insert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        repo.insert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        repo.delete(item)
    }

    fun getAllShoppingItems() = CoroutineScope(Dispatchers.Main).launch{
        repo.getAllShoppingItems()
    }
}