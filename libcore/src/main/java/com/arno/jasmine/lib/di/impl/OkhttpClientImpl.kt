package com.arno.jasmine.lib.di.impl

import com.arno.jasmine.lib.config.JAppliesOptions
import okhttp3.OkHttpClient

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/21
 *     desc  :
 * </pre>
 */
class OkhttpClientImpl(
    builder: OkHttpClient.Builder?,
    options: JAppliesOptions.OkHttpClientOptions?,
) {
    var okHttpClient: OkHttpClient?

    init {
        options?.applyOptions(builder)
        okHttpClient = builder?.build()
    }
}