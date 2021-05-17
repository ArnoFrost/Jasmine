package com.arno.jasmine.main

import com.arno.jasmine.R
import com.arno.jasmine.databinding.ActivityMainBinding
import com.arno.jasmine.lib.core.mvvm.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun providerVMClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {
        super.initView()
        mBinding.mViewModel = mViewModel
        mBinding.btnRequestTitle.setOnClickListener {
            mViewModel.requestTitle()
        }
    }
}