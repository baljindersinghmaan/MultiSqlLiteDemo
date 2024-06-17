package com.baljinder.sqllitedemo

import com.baljinder.sqllitedemo.cache.Database
import com.baljinder.sqllitedemo.cache.DatabaseDriverFactory
import com.baljinder.sqllitedemo.entity.RocketLaunch
import com.baljinder.sqllitedemo.network.SpaceXApi

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory, val api: SpaceXApi) {
    private val database = Database(databaseDriverFactory)

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearAndCreateLaunches(it)
            }
        }
    }
}