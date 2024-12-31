package com.example.shoppinglist_app.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist_app.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1                         //Whenever u modify the database, u need to change the version ??? TBR
)
abstract class ShoppingDatabase: RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDAO


    companion object {
        @Volatile
        private var INSTANCE: ShoppingDatabase? = null

        //Singleton pattern Implem 1: make sure only one instance exist at a time: volatile + synchronized
        fun getDatabase(context: Context): ShoppingDatabase{
            return INSTANCE ?: synchronized(this){
                var instance = Room.databaseBuilder( context.applicationContext, ShoppingDatabase::class.java, "Shopping_database.db").build()
                INSTANCE = instance
                instance
            }
        }
        /*
        private val lock = Any()
        //Singleton pattern Implem 2: I'll use invoke()
        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java, "Shopping_database.db").build()
        operator fun invoke(context: Context) = INSTANCE ?:synchronized(lock){
            INSTANCE ?: createDatabase(context).also { INSTANCE = it}
        }
        */
    }


}