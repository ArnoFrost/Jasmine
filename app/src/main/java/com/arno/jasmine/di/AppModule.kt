package com.arno.jasmine.di

import com.arno.jasmine.lib.di.ModuleConfig
import org.koin.dsl.module

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/25
 *     desc  : Jasmine框架配置
 * </pre>
 */
val appModule = module {
    single {
        ModuleConfig.Builder()
            .setBaseUrl("https://www.baidu.com")
            .setOkHttpClientOptions(get())
            .setRetrofitOptions(get())
            .setRoomDatabaseOptions(get())
    }
}