package com.skill_factory.unit6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.skill_factory.unit6.model.Item
import com.skill_factory.unit6.model.Product
import com.skill_factory.unit6.R
import com.skill_factory.unit6.databinding.ItemBinding

class ProductDelegateAdapter :
    AbsListItemAdapterDelegate<Product, Item, ProductDelegateAdapter.ViewHolder>() {
    inner class ViewHolder(val itemBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(product: Product) {
            itemBinding.icon.setImageResource(product.idIcon)
            itemBinding.textName.text = product.name
            itemBinding.textDesc.text = product.desc
        }
    }

    override fun isForViewType(item: Item, items: MutableList<Item>, position: Int): Boolean {
        return item is Product
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(item: Product, holder: ViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }
}