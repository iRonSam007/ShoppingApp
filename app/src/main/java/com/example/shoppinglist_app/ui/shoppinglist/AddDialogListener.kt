package com.example.shoppinglist_app.ui.shoppinglist

import com.example.shoppinglist_app.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}