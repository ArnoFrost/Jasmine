package com.arno.jasmine.lib

import android.app.Application
import com.arno.jasmine.lib.di.ModuleConfig
import org.koin.core.module.Module

interface IJasmine {
    /**
     * 初始化
     * @param application Application
     * @param builder Builder
     */
    fun init(application: Application, builder: ModuleConfig.Builder)

    /**
     * 添加module
     * @param module Module
     */
    fun loadModules(vararg module: Module)

    /**
     * 卸载module
     * @param module Module
     */
    fun unloadModules(vararg module: Module)
}
