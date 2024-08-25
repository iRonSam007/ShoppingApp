package com.example.shoppinglist_app.ui.shoppinglist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist_app.R
import com.example.shoppinglist_app.data.db.ShoppingDatabase
import com.example.shoppinglist_app.data.repositories.ShoppingRepository
import com.example.shoppinglist_app.other.ShoppingItemRecyclerViewAdapter


class ShoppingActivity : AppCompatActivity() {
    val TAG: String = "ShoppingApp"

    //If your viewModel constructor has paramter, it will need a foctory to be instatiated
    private val myViewModel: ShoppingViewModel by viewModels <ShoppingViewModel> {
        ShoppingViewModelFactory(ShoppingRepository( ShoppingDatabase.getDatabase(this)))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopping)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val adapter = ShoppingItemRecyclerViewAdapter(listOf(), myViewModel)
        val rvShoppingItems = findViewById<RecyclerView>(R.id.rv_shopping_items)
        val fab = findViewById<RecyclerView>(R.id.fab)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        myViewModel.getAllShoppingItems().observe(this, Observer { //Deprecated
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(
                this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        myViewModel.insert(item)
                    }
                }).show()
        }


    }
}


