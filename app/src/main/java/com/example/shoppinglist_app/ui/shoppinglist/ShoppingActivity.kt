package com.example.shoppinglist_app.ui.shoppinglist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist_app.R
import com.example.shoppinglist_app.data.db.ShoppingDatabase
import com.example.shoppinglist_app.data.repositories.ShoppingRepository


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

        /*
        //Instantiate every think u need: this a bad habits, cz it makes database access dependent on this activity lifecycle
        //The professional practice is dependency injection ...
        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val vmFactory = ShoppingViewModelFactory(repository)
        //Usually this will instanciate a viewModel from file ... using viewModel factory instance.... but this is deprecated
        //val viewModel = ViewModelProvider.of(this, vmFactory).get(ShoppingViewModel::class.java)
        val viewModel = ViewModelProvider(this, vmFactory).get(ShoppingViewModel::class.java)
        //NB: ViewModelProviders.of is deprecated, now we use CustomeViewModel by viewModels(){}
        */


    }
}


