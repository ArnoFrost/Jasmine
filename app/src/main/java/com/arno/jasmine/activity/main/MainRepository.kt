package com.arno.jasmine.activity.main

import android.content.Context
import com.arno.jasmine.lib.data.IDataRepository

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/21
 *     desc  :
 * </pre>
 */
class MainRepository :IDataRepository {
    override fun getContext(): Context? {
        TODO("Not yet implemented")
    }

    override fun <T> getRetrofitService(service: Class<T>): T? {
        TODO("Not yet implemented")
    }

    override fun <T : androidx.room.RoomDatabase> getRoomDatabase(
        database: Class<T>,
        dbName: String?,
    ): T? {
        TODO("Not yet implemented")
    }
}