package com.arno.jasmine.lib.data

import android.app.Application
import android.content.Context
import androidx.collection.LruCache
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arno.jasmine.lib.common.util.Preconditions
import com.arno.jasmine.lib.config.Constants
import com.arno.jasmine.lib.config.JAppliesOptions
import dagger.Lazy
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/20
 *     desc  :
 * </pre>
 */
@Singleton
class DataRepository : IDataRepository {

    @Inject
    constructor()

    @JvmField
    @Inject
    var mRetrofit: Lazy<Retrofit>? = null

    @JvmField
    @Inject
    var mApplication: Application? = null

    @JvmField
    @Inject
    var mRoomDatabaseOptions: JAppliesOptions.RoomDatabaseOptions? = null

    /**
     * 缓存 Retrofit Service
     */
    private var mRetrofitServiceCache: LruCache<String?, Any>? = null

    /**
     * 缓存 RoomDatabase
     */
    private var mRoomDatabaseCache: LruCache<String?, Any>? = null


    /**
     * 提供上下文[Context]
     * @return [.mApplication]
     */
    override fun getContext(): Context {
        return mApplication!!
    }

    /**
     * 传入Class 通过[retrofit2.Retrofit.create] 获得对应的Class
     * @param service
     * @param <T>
     * @return [retrofit2.Retrofit.create]
    </T> */
    @Throws(Exception::class)
    override fun <T> getRetrofitService(service: Class<T>): T {
        if (mRetrofitServiceCache == null) {
            mRetrofitServiceCache = LruCache(Constants.DEFAULT_RETROFIT_SERVICE_MAX_SIZE)
        }
        Preconditions.checkNotNull(mRetrofitServiceCache)
        Preconditions.checkNotNull(service.canonicalName)
        mRetrofitServiceCache?.let { serviceCache ->
            service.canonicalName?.let { canonicalName ->
                var retrofitService: T? = serviceCache[canonicalName] as? T
                if (retrofitService == null) {
                    synchronized(serviceCache) {
                        if (retrofitService == null) {
                            retrofitService = mRetrofit?.get()?.create(service)
                            Preconditions.checkNotNull(retrofitService)
                            //缓存
                            serviceCache.put(canonicalName, retrofitService!!)
                        }
                    }
                }
                return retrofitService ?: throw Exception("getRetrofitService null")
            }
        }
        throw Exception("getRetrofitService null")
    }

    /**
     * 传入Class 通过[Room.databaseBuilder],[#build()][<]获得对应的Class
     * @param database
     * @param dbName 为`null`时，默认为[Constants.DEFAULT_DATABASE_NAME]
     * @param <T>
     * @return  [androidx.room.RoomDatabase.Builder.build]
     */
    @Throws(Exception::class)
    @Suppress("UNCHECKED_CAST")
    override fun <T : RoomDatabase> getRoomDatabase(database: Class<T>, dbName: String?): T {
        if (mRoomDatabaseCache == null) {
            mRoomDatabaseCache = LruCache(Constants.DEFAULT_ROOM_DATABASE_MAX_SIZE)
        }
        Preconditions.checkNotNull(mRoomDatabaseCache)
        Preconditions.checkNotNull(database.canonicalName)
        mRoomDatabaseCache?.let { databaseCache ->
            database.canonicalName?.let { canonicalName ->
                var roomDatabase: T? = (databaseCache[canonicalName] as? T)
                synchronized(databaseCache) {
                    if (roomDatabase == null) {
                        val builder: RoomDatabase.Builder<T> =
                            Room.databaseBuilder(getContext().applicationContext,
                                database,
                                dbName ?: Constants.DEFAULT_DATABASE_NAME)
                        mRoomDatabaseOptions?.applyOptions(builder = builder)
                        roomDatabase = builder.build()?.apply {
                            databaseCache.put(canonicalName, this)
                        }
                    }
                }
                return roomDatabase ?: throw Exception("getRoomDatabase is null")
            }
        }
        throw Exception("getRoomDatabase is null")
    }
}