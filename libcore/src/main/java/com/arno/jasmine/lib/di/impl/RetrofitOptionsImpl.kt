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
class RetrofitOptionsImpl {
    val builder: ModuleConfig.Builder by inject(ModuleConfig::class.java)
}
