package com.xenia.shopinglist.di

import com.xenia.shopinglist.data.ShopListRepositoryImpl
import com.xenia.shopinglist.domain.repository.ShopListRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

}
