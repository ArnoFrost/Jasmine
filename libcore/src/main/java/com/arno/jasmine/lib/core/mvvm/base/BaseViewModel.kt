package com.arno.jasmine.lib.core.mvvm.base

import androidx.lifecycle.ViewModel
import com.arno.jasmine.lib.util.JLog

/***
 *
 * Created by Arno on 2021/05/14.
 *
 */

abstract class BaseViewModel : ViewModel() {
    init {
        JLog.d(javaClass.simpleName, "init")
    }

    override fun onCleared() {
        super.onCleared()
        JLog.d(javaClass.simpleName, "onCleared")
    }
}