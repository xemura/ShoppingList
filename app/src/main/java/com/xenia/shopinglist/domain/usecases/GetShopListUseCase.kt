package com.xenia.shopinglist.domain.usecases

import androidx.lifecycle.LiveData
import com.xenia.shopinglist.domain.model.ShopItem
import com.xenia.shopinglist.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}