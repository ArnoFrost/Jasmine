package com.arno.jasmine.lib.di

import com.arno.jasmine.lib.config.JAppliesOptions
import okhttp3.HttpUrl
import org.koin.dsl.module

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/21
 *     desc  :
 * </pre>
 */
val optionModule = module {
    single {
        fun provideBaseUrl(builder: ModuleConfig.Builder): HttpUrl? {
            return builder.baseUrl
        }
    }
    single {
        fun provideRetrofitOptions(builder: ModuleConfig.Builder): JAppliesOptions.RetrofitOptions? {
            return builder.retrofitOptions
        }
    }

    single {
        fun provideOkHttpClientOptions(builder: ModuleConfig.Builder): JAppliesOptions.OkHttpClientOptions? {
            return builder.okHttpClientOptions
        }
    }

    single {
        fun provideRoomDatabaseOptions(builder: ModuleConfig.Builder): JAppliesOptions.RoomDatabaseOptions? {
            return builder.roomDatabaseOptions
        }
    }
}