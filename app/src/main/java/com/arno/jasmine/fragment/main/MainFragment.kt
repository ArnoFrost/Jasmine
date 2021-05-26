package com.arno.jasmine.fragment.main

import com.arno.jasmine.R
import com.arno.jasmine.databinding.FragmentMainBinding
import com.arno.jasmine.lib.core.mvvm.base.BaseFragment


class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>() {

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment()
    }

    override fun providerVMClass(): Class<MainFragmentViewModel> = MainFragmentViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_main
    override fun initView() {

    }

    override fun initData() {
        mBinding?.mViewModel = mViewModel

        //处理加载Loading
        mViewModel?.isLoading?.observe(this,
            {
                if (it) {
                    showLoadingView()
                } else {
                    hideLoadingView()
                }
            })
    }
}