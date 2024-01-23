package com.xenia.shopinglist.domain

data class ShopItem(
    val id: Int,
    val name: String,
    val count: Int,
    val isPick: Boolean,
)