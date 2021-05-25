package com.arno.jasmine.lib.di

import com.arno.jasmine.lib.core.mvvm.base.BaseModel
import com.arno.jasmine.lib.core.mvvm.base.BaseViewModel
import com.arno.jasmine.lib.data.DataRepository
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
 *     desc  : 框架依赖注入配置
 * </pre>
 */
val coreModule = module {
    factory {
        scope<BaseViewModel<BaseModel>> {
            scoped { BaseModel(get()) }
        }
    }
    factory { BaseModel(get()) }

    single { HttpUrlImpl() }

    factory { RetrofitBuilderImpl(get(), get()) }

    single { RetrofitImpl(get(), get()) }

    single { OkhttpClientImpl(get(), get()) }

    single { OkHttpClient.Builder() }

    single { DataRepository() }

}