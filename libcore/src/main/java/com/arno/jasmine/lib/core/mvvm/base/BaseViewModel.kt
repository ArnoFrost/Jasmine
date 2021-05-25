package com.arno.jasmine.lib.core.mvvm.base

import androidx.lifecycle.ViewModel
import com.arno.jasmine.lib.core.mvvm.i.IViewModel
import com.arno.jasmine.lib.common.util.JLog

/***
 *
 * Created by Arno on 2021/05/14.
 * ViewModel 层
 */

abstract class BaseViewModel<out M : BaseModel> : ViewModel(), IViewModel {
    abstract val mModel: @UnsafeVariance M?

    init {
        doOnInit()
    }

    override fun onCleared() {
        doOnCleared()
        super.onCleared()
    }

    final override fun doOnInit() {
        JLog.d(javaClass.simpleName, "init")
    }

    override fun doOnCleared() {
        JLog.d(javaClass.simpleName, "onCleared mModel ${mModel?.javaClass?.simpleName}")
        mModel?.released()
    }
}