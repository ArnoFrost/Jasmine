package com.arno.jasmine.activity.main

import com.arno.jasmine.lib.core.mvvm.base.BaseViewModel
import org.koin.java.KoinJavaComponent.inject

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : MainActivity VM层
 * </pre>
 */
class MainViewModel : BaseViewModel<MainModel>() {
    override val mModel: MainModel? by inject(MainModel::class.java)

}