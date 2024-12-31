package com.androiddevs.grocerylist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog

import com.example.shoppinglist_app.data.db.entities.ShoppingItem
import com.example.shoppinglist_app.R
import com.example.shoppinglist_app.ui.shoppinglist.AddDialogListener


class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.dialog_add_shopping_item)

        //This can be replaced with right import SFI //1- Kotlin sysnthetic view binding(deprecated) //ViewBinding add:
        // viewBinding {
        //        enabled = true
        //    } in gradle and then use:
        val tvAdd = findViewById<TextView>(R.id.tvAdd)
        val tvCancel = findViewById<TextView>(R.id.tvCancel)
        val etName = findViewById<TextView>(R.id.etName)
        val etAmount = findViewById<TextView>(R.id.etAmount)

        tvAdd?.setOnClickListener {
            val name = etName?.text.toString()
            val amount = etAmount?.text.toString().toInt()
            if(name.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel?.setOnClickListener {
            cancel()
        }
    }
}