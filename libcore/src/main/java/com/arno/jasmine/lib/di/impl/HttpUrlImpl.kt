package com.arno.jasmine.lib.di.impl

import com.arno.jasmine.lib.di.ModuleConfig
import org.koin.java.KoinJavaComponent.inject

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/21
 *     desc  :
 * </pre>
 */
class HttpUrlImpl() {
    val builder: ModuleConfig.Builder by inject(ModuleConfig.Builder::class.java)
    var httpUrlImpl = builder.baseUrl
}