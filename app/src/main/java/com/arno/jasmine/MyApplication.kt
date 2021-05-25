package com.arno.jasmine

import android.app.Application
import com.arno.jasmine.di.mainModule
import com.arno.jasmine.lib.Jasmine
import com.arno.jasmine.lib.di.ModuleConfig
import com.blankj.utilcode.util.Utils

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
        initUtil()
        initJasmine()
    }

    private fun initUtil() {
        Utils.init(this)
    }

    private fun initJasmine() {
        val builder = ModuleConfig.Builder()
            .setBaseUrl("https://www.baidu.com")
        Jasmine.init(this@MyApplication, builder)
        //业务模块
        Jasmine.loadModules(mainModule)
    }

}