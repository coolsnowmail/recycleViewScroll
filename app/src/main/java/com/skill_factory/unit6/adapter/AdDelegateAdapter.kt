package com.skill_factory.unit6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.skill_factory.unit6.model.Ad
import com.skill_factory.unit6.model.Item
import com.skill_factory.unit6.databinding.ItemAdBinding

class AdDelegateAdapter : AbsListItemAdapterDelegate<Ad, Item, AdDelegateAdapter.ViewHolder>() {
    class ViewHolder(val itemAdBinding: ItemAdBinding) :
        RecyclerView.ViewHolder(itemAdBinding.root) {
        fun bind(ad: Ad) {
            itemAdBinding.title.text = ad.title
            itemAdBinding.content.text = ad.content
        }
    }

    override fun isForViewType(item: Item, items: MutableList<Item>, position: Int): Boolean {
        return item is Ad
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            ItemAdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(item: Ad, holder: ViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }
}