package com.arno.jasmine.lib.core.mvvm.i

import androidx.annotation.LayoutRes

interface IActivity {
    @LayoutRes
    fun getLayoutId(): Int

    fun initView()

    fun initData()
}
