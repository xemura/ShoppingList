package com.xenia.shopinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.xenia.shopinglist.R
import com.xenia.shopinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShopListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) { it ->
            adapter.shopList = it
        }
    }

    private fun setUpRecyclerView() {
        recyclerView = findViewById(R.id.rv_shop_list)
        adapter = ShopListAdapter()
        recyclerView.adapter = adapter

        recyclerView.recycledViewPool.setMaxRecycledViews(
            ShopListAdapter.VIEW_TYPE_ENABLED,
            ShopListAdapter.MAX_POOL_SIZE
        )
        recyclerView.recycledViewPool.setMaxRecycledViews(
            ShopListAdapter.VIEW_TYPE_DISABLED,
            ShopListAdapter.MAX_POOL_SIZE
        )

        adapter.onShopItemLongClickListener =  {
                viewModel.changeEnableState(it)
        }
    }
}









