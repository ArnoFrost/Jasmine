package com.arno.jasmine

import android.app.Application
import com.arno.jasmine.lib.net.NetworkManager
import com.blankj.utilcode.util.Utils
import dagger.hilt.android.HiltAndroidApp

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : JasmineApplication
 * </pre>
 */
@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initUtil()
        initNetwork()
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