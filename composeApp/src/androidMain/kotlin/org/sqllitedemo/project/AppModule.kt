package org.sqllitedemo.project

import com.baljinder.sqllitedemo.SpaceXSDK
import com.baljinder.sqllitedemo.cache.AndroidDatabaseDriverFactory
import com.baljinder.sqllitedemo.network.SpaceXApi
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<SpaceXApi> { SpaceXApi() }
    single<SpaceXSDK> {
        SpaceXSDK(
            databaseDriverFactory = AndroidDatabaseDriverFactory(
                androidContext()
            ), api = get()
        )
    }
    viewModel { RocketLaunchViewModel(sdk = get()) }
}