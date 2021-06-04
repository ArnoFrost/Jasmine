package com.arno.jasmine.lib.core.mvvm.base

import androidx.room.RoomDatabase
import com.arno.jasmine.lib.config.Constants
import com.arno.jasmine.lib.core.mvvm.i.IModel
import com.arno.jasmine.lib.data.DataRepository

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : Model层 加入网络和数据库接口
 * </pre>
 */
open class BaseModel(var mDataRepository: DataRepository?) : IModel {

    override fun released() {
        mDataRepository = null
    }

    /**
     * 传入Class 获得[retrofit2.Retrofit.create] 对应的Class
     * @param service
     * @param
     * @return [retrofit2.Retrofit.create]
     */
    open fun <T> getRetrofitService(service: Class<T>): T? {
        return mDataRepository?.getRetrofitService(service)
    }

    /**
     * 传入Class 通过[androidx.room.Room.databaseBuilder],[#build()][<]获得对应的Class
     * @param database
     * @param <T>
     * @return [androidx.room.RoomDatabase.Builder.build]
     */
    open fun <T : RoomDatabase> getRoomDatabase(database: Class<T>): T? {
        return getRoomDatabase(database, Constants.DEFAULT_DATABASE_NAME)
    }

    /**
     * 传入Class 通过[androidx.room.Room.databaseBuilder],[#build()][<]获得对应的Class
     * @param database
     * @param dbName
     * @param <T>
     * @return [androidx.room.RoomDatabase.Builder.build]
     */
    open fun <T : RoomDatabase> getRoomDatabase(database: Class<T>, dbName: String?): T? {
        return mDataRepository?.getRoomDatabase(database, dbName)
    }
}
