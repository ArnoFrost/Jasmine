package com.arno.jasmine

import android.app.Application
import com.arno.jasmine.di.mainModule
import com.arno.jasmine.lib.di.coreModule
import com.arno.jasmine.lib.di.netModule
import com.arno.jasmine.lib.di.optionModule
import com.arno.jasmine.lib.di.repositoryModule
import com.arno.jasmine.lib.net.NetworkManager
import com.blankj.utilcode.util.Utils
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

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
        initNetwork()
    }

    private fun initDi() {
        startKoin {
            androidContext(this@MyApplication)
            modules(mainModule)
            modules(optionModule)
            modules(coreModule)
            modules(netModule)
            modules(repositoryModule)

        }
    }

    private fun initUtil() {
        Utils.init(this)
    }

    private fun initNetwork() {
        val networkBuilder = NetworkManager.Builder()
            .setDefaultTime(30L)
            .setBaseUrl("https://www.baidu.com")
        NetworkManager.initNetwork(networkBuilder)
    }
}