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
}