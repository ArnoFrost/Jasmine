package com.arno.jasmine.main

import androidx.lifecycle.MutableLiveData
import com.arno.jasmine.lib.core.mvvm.base.BaseViewModel

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  :
 * </pre>
 */
class MainViewModel : BaseViewModel<MainModel>() {
    override var mModel: MainModel? = MainModel()
    val mTitle: MutableLiveData<String> = MutableLiveData("Welcome to Jasmine~")

    fun requestTitle() {
        mModel?.let {
            it.updateTitle()
            mTitle.postValue(it.title)
            mTitle.value
        }

    }

}