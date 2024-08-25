package com.example.shoppinglist_app.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist_app.R
import com.example.shoppinglist_app.data.db.entities.ShoppingItem
import com.example.shoppinglist_app.ui.shoppinglist.ShoppingViewModel

class ShoppingItemRecyclerViewAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemRecyclerViewAdapter.ShoppingViewHolder>() { //Wa lhma9 hada, Class A : RV.Adapter<A> ==> generic shit + inner class

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }


    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.findViewById<TextView>(R.id.tvName).text = curShoppingItem.name
        holder.itemView.findViewById<TextView>(R.id.tvAmount).text = "${curShoppingItem.amount}"

        holder.itemView.findViewById<TextView>(R.id.ivDelete).setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.findViewById<TextView>(R.id.ivDelete).setOnClickListener {
            curShoppingItem.amount++
            viewModel.insert(curShoppingItem)
        }

        holder.itemView.findViewById<TextView>(R.id.ivDelete).setOnClickListener {
            if(curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewModel.insert(curShoppingItem)
            }
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) //After we are sourcing from View
}