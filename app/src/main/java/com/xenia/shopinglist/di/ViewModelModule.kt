package com.xenia.shopinglist.di

import androidx.lifecycle.ViewModel
import com.xenia.shopinglist.presentation.viewmodels.MainViewModel
import com.xenia.shopinglist.presentation.viewmodels.ShopItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    @Binds
    fun bindShopItemViewModel(impl: ShopItemViewModel): ViewModel

}