package com.arno.jasmine.lib.data

import android.content.Context
import androidx.room.RoomDatabase

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/20
 *     desc  : 数据接口层
 * </pre>
 */
interface IDataRepository {
    /**
     * 提供上下文[Context]
     * @return {@lik Context}
     */
    fun getContext(): Context?

    /**
     * 传入Class 通过[retrofit2.Retrofit.create] 获得对应的Class
     * @param service
     * @param <T>
     * @return [retrofit2.Retrofit.create]
     */
    fun <T> getRetrofitService(service: Class<T>): T

    /**
     * 传入Class 通过[androidx.room.Room.databaseBuilder],[#build()][<]获得对应的Class
     * @param database
     * @param dbName
     * @param <T>
     * @return [androidx.room.RoomDatabase.Builder.build]
     */
    fun <T : RoomDatabase> getRoomDatabase(database: Class<T>, dbName: String?): T

}