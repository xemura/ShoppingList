package com.xenia.shopinglist.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.xenia.shopinglist.data.ShopListRepositoryImpl
import com.xenia.shopinglist.domain.model.ShopItem
import com.xenia.shopinglist.domain.usecases.AddShopItemUseCase
import com.xenia.shopinglist.domain.usecases.DeleteShopItemUseCase
import com.xenia.shopinglist.domain.usecases.EditShopItemUseCase
import com.xenia.shopinglist.domain.usecases.GetShopItemUseCase
import com.xenia.shopinglist.domain.usecases.GetShopListUseCase
import java.lang.Exception

class ShopItemViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    fun getShopItem(shopItemId: Int) {
        val item = getShopItemUseCase.getShopItem(shopItemId)
    }

    fun addShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            val shopItem = ShopItem (
                name = name,
                count = count,
                enabled = true
            )
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            val shopItem = ShopItem (
                name = name,
                count = count,
                enabled = true
            )
            editShopItemUseCase.editShopItem(shopItem)
        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true
        if (name.isBlank()) {
            // TODO: show error input name
            result = false
        }
        if (count <= 0) {
            // TODO: show error input count
            result = false
        }
        return result
    }

}