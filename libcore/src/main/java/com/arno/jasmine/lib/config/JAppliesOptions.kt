package com.arno.jasmine.lib.config

import android.content.Context
import androidx.room.RoomDatabase
import com.arno.jasmine.lib.di.ModuleConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/20
 *     desc  : Jasmine 初始化配置参数
 * </pre>
 */
abstract class JAppliesOptions {
    /**
     * 为框架提供一些配置参数入口
     * @param context
     * @param builder
     */
    abstract fun applyOptions(context: Context?, builder: ModuleConfig.Builder?)

    /**
     * 为框架中的[Retrofit]提供配置参数入口
     */
    abstract class RetrofitOptions {
        abstract fun applyOptions(builder: Retrofit.Builder?)
    }

    /**
     * 为框架中的[okhttp3.OkHttpClient]提供配置参数入口
     */
    abstract class OkHttpClientOptions {
        abstract fun applyOptions(builder: OkHttpClient.Builder?)
    }

    /**
     * 为框架中的[RoomDatabase]提供配置参数入口
     */
    abstract class RoomDatabaseOptions {
        abstract fun <T : RoomDatabase> applyOptions(builder: RoomDatabase.Builder<T>)
    }
}
