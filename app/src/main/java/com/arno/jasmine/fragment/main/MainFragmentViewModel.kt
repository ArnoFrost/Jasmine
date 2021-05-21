package com.arno.jasmine.fragment.main

import com.arno.jasmine.lib.core.mvvm.base.BaseViewModel
import org.koin.java.KoinJavaComponent.inject

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  :
 * </pre>
 */
class MainFragmentViewModel : BaseViewModel<MainFragmentModel>() {
    override val mModel: MainFragmentModel? by inject(MainFragmentModel::class.java)
}