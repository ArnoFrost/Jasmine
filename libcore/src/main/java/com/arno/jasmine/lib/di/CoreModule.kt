package com.arno.jasmine.lib.di

import com.arno.jasmine.lib.core.mvvm.base.BaseModel
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
}