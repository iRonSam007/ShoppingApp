package com.example.shoppinglist_app.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist_app.data.repositories.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(private val repo: ShoppingRepository): ViewModelProvider.Factory {

    @Override
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repo) as T
    }
}