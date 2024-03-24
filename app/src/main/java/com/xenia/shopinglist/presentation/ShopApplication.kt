package com.xenia.shopinglist.presentation

import android.app.Application
import com.xenia.shopinglist.di.DaggerApplicationComponent

class ShopApplication: Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(
            this
        )
    }
}