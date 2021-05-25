package com.arno.jasmine.activity.main

import androidx.fragment.app.commitNow
import com.arno.jasmine.R
import com.arno.jasmine.databinding.ActivityMainBinding
import com.arno.jasmine.fragment.main.MainFragment
import com.arno.jasmine.lib.core.mvvm.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun provideVMClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {
        super.initView()
        mBinding.mViewModel = mViewModel
        supportFragmentManager.commitNow {
            add(R.id.main_root, MainFragment.newInstance(), "MainFragment")
        }
    }
}