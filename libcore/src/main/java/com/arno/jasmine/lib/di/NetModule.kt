package com.arno.jasmine.lib.di

import com.arno.jasmine.lib.config.JAppliesOptions
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/21
 *     desc  :
 * </pre>
 */
val netModule = module {
    single {
        fun provideRetrofit(
            builder: Retrofit.Builder?,
            options: JAppliesOptions.RetrofitOptions?,
        ): Retrofit? {
            options?.applyOptions(builder)
            return builder?.build()
        }
    }
    single {
        fun provideOkHttpClient(
            builder: OkHttpClient.Builder?,
            options: JAppliesOptions.OkHttpClientOptions?,
        ): OkHttpClient? {
            options?.applyOptions(builder)
            return builder?.build()
        }
    }
    single {
        fun provideRetrofitBuilder(
            httpUrl: HttpUrl,
            client: OkHttpClient,
        ): Retrofit.Builder {
            return Retrofit.Builder().apply {
                baseUrl(httpUrl)
                    .client(client)
            }
        }
    }
}