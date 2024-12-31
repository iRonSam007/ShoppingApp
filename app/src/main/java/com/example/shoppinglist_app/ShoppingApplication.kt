package com.example.shoppinglist_app

import android.app.Application
import org.KodeinAware

//Here: for dependency injection, good practice, to make viewModel independent from any activity lifecycle
class ShoppingApplication: Application(), KodeinAware {
}