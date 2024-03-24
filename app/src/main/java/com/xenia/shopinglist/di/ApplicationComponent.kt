package com.xenia.shopinglist.di

import android.app.Application
import android.content.Context
import com.xenia.shopinglist.presentation.activities.MainActivity
import com.xenia.shopinglist.presentation.activities.ShopItemActivity
import com.xenia.shopinglist.presentation.fragments.ShopItemFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [
    DataModule::class,
    DomainModule::class,
    ViewModelModule::class
])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(activity: ShopItemFragment)

    @Component.Factory
    interface ApplicationComponentBuilder {
        fun create(
            @BindsInstance application: Application,
        ): ApplicationComponent
    }

}