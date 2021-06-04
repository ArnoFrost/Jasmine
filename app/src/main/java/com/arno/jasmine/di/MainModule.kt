package com.arno.jasmine.di

import com.arno.jasmine.activity.main.MainModel
import com.arno.jasmine.fragment.main.MainFragmentModel
import org.koin.dsl.module

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/21
 *     desc  :
 * </pre>
 */
val mainModule = module {
    single {
        MainModel(get())
    }
    single {
        MainFragmentModel(get())
    }
}
