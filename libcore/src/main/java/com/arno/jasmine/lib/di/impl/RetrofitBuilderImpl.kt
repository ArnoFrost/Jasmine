package com.arno.jasmine.lib.di.impl

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/21
 *     desc  :
 * </pre>
 */
class RetrofitBuilderImpl(
    httpUrl: HttpUrl,
    client: OkHttpClient,
) {
    var retrofitBuilder: Retrofit.Builder? = Retrofit.Builder().apply {
        baseUrl(httpUrl).client(client)
    }

}