package com.xenia.shopinglist.di

import android.app.Application
import com.xenia.shopinglist.data.AppDatabase
import com.xenia.shopinglist.data.ShopListDao
import com.xenia.shopinglist.data.ShopListRepositoryImpl
import com.xenia.shopinglist.domain.repository.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @ApplicationScope
    @Provides
    fun provideShopListDao(application: Application): ShopListDao {
        return AppDatabase.getInstance(application).shopListDao()
    }
}