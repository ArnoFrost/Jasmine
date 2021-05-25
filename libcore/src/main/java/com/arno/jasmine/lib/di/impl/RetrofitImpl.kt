package com.arno.jasmine.lib.di.impl

import com.arno.jasmine.lib.config.JAppliesOptions
import retrofit2.Retrofit

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/21
 *     desc  :
 * </pre>
 */
class RetrofitImpl(
    builder: Retrofit.Builder?,
    options: JAppliesOptions.RetrofitOptions?,
) {
    var retrofit: Retrofit?

    init {
        options?.applyOptions(builder)
        retrofit = builder?.build()
    }
}