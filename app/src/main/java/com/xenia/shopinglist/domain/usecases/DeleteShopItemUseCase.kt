package com.xenia.shopinglist.domain.usecases

import com.xenia.shopinglist.domain.model.ShopItem
import com.xenia.shopinglist.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}