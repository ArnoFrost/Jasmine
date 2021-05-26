package com.arno.jasmine.lib.core.mvvm.i

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

interface IView : LifecycleOwner {
    fun showLoadingView()

    fun hideLoadingView()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun releaseView()

}