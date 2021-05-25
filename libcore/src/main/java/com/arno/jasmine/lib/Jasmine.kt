package com.arno.jasmine.lib

import android.app.Application
import com.arno.jasmine.lib.common.util.JLog
import com.arno.jasmine.lib.di.ModuleConfig
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/25
 *     desc  : Jasmine 对外操作暴露
 * </pre>
 */
object Jasmine : IJasmine {
    private const val TAG = "Jasmine"
    override fun init(application: Application, builder: ModuleConfig.Builder) {
        ModuleConfig.initModule(application, builder)
    }

    override fun loadModules(vararg module: Module) {
        JLog.d(TAG, "loadModules = $module")
        module.forEach {
            loadKoinModules(it)
        }
    }

    override fun unloadModules(vararg module: Module) {
        JLog.d(TAG, "unloadModules = $module")
        module.forEach {
            unloadKoinModules(it)
        }
    }
}