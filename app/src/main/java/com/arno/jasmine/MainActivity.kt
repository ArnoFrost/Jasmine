package com.arno.jasmine

import com.arno.jasmine.databinding.ActivityMainBinding
import com.arno.jasmine.lib.core.mvvm.base.BaseActivity
import com.arno.jasmine.main.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun providerVMClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun getLayoutId() = R.layout.activity_main

    override fun initData() {
        super.initData()
        mBinding.welcome.text = getString(R.string.test_welcome)
    }
}