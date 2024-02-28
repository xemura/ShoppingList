package com.xenia.shopinglist.domain.usecases

import com.xenia.shopinglist.domain.model.ShopItem
import com.xenia.shopinglist.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}