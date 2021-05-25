package com.arno.jasmine

import android.app.Application
import com.arno.jasmine.di.appModule
import com.arno.jasmine.di.mainModule
import com.arno.jasmine.lib.di.coreModule
import com.blankj.utilcode.util.Utils
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : JasmineApplication
 * </pre>
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initDi()
        initUtil()
    }

    private fun initDi() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            //框架核心模块
            modules(coreModule)
            //App基础
            modules(appModule)
            //业务模块
            modules(mainModule)
        }
    }

    private fun initUtil() {
        Utils.init(this)
    }
}