package com.xenia.shopinglist.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xenia.shopinglist.R
import com.xenia.shopinglist.domain.ShopItem

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null

    class ShopItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        Log.d("RecyclerViewAdapter", "onCreateViewHolder")

        val layout = if (viewType == 0) {
            R.layout.item_shop_disabled
        } else R.layout.item_shop_enabled
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )

        return ShopItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        Log.d("RecyclerViewAdapter", "onBindViewHolder")
        val shopItem = shopList[position]

        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
    }

    override fun getItemViewType(position: Int): Int {
        val viewType = if (shopList[position].enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }

        return viewType
    }

    interface OnShopItemClickListener {
        fun onShopItemLongClick(shopItem: ShopItem)
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = 0
        const val MAX_POOL_SIZE = 15
    }
}















