package com.arno.jasmine.lib.di

import com.arno.jasmine.lib.config.JAppliesOptions
import com.arno.jasmine.lib.core.mvvm.base.BaseModel
import com.arno.jasmine.lib.di.impl.HttpUrlImpl
import com.arno.jasmine.lib.di.impl.OkhttpClientImpl
import com.arno.jasmine.lib.di.impl.RetrofitBuilderImpl
import com.arno.jasmine.lib.di.impl.RetrofitImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/21
 *     desc  :
 * </pre>
 */
val coreModule = module {
    factory { BaseModel(get()) }

    single {
        HttpUrlImpl()
    }

    factory {
        RetrofitBuilderImpl(get(), get())
    }

    single {
        RetrofitImpl(get(), get())
    }

    single {
        OkhttpClientImpl(get(), get())
    }

    single {
        OkHttpClient.Builder()
    }


    // single {
    //     fun provideRetrofitOptions(builder: ModuleConfig.Builder): JAppliesOptions.RetrofitOptions? {
    //         return builder.retrofitOptions
    //     }
    // }
    //
    // single {
    //     fun provideOkHttpClientOptions(builder: ModuleConfig.Builder): JAppliesOptions.OkHttpClientOptions? {
    //         return builder.okHttpClientOptions
    //     }
    // }
    //
    // single {
    //     fun provideRoomDatabaseOptions(builder: ModuleConfig.Builder): JAppliesOptions.RoomDatabaseOptions? {
    //         return builder.roomDatabaseOptions
    //     }
    // }

}