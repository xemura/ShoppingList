package com.xenia.shopinglist.presentation

import androidx.lifecycle.ViewModel
import com.xenia.shopinglist.data.ShopListRepositoryImpl
import com.xenia.shopinglist.domain.DeleteShopItemUseCase
import com.xenia.shopinglist.domain.EditShopItemUseCase
import com.xenia.shopinglist.domain.GetShopListUseCase
import com.xenia.shopinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}