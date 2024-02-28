package com.xenia.shopinglist.domain.usecases

import com.xenia.shopinglist.domain.model.ShopItem
import com.xenia.shopinglist.domain.repository.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun getShopItem(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}