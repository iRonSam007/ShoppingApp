package com.example.shoppinglist_app.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shopping_items")    //This annotation that means our class is a table ... TBR
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
) {
    @PrimaryKey(autoGenerate = true)    //Mandatory to have a primary key if annotated as a room table
    var id: Int? = null
}