package com.arno.jasmine.lib.di

import com.arno.jasmine.lib.data.DataRepository
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/20
 *     desc  :
 * </pre>
 */
val repositoryModule = module {
    factory { DataRepository() } bind DataRepository::class
}