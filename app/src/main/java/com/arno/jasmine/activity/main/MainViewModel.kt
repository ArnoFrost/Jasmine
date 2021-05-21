package com.arno.jasmine.activity.main

import androidx.lifecycle.MutableLiveData
import com.arno.jasmine.lib.core.mvvm.base.BaseViewModel
import org.koin.java.KoinJavaComponent.inject

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  :
 * </pre>
 */
class MainViewModel : BaseViewModel<MainModel>() {
    override val mModel: MainModel? by inject(MainModel::class.java)
    val mTitle: MutableLiveData<String> = MutableLiveData("Welcome to Jasmine~")

    fun requestTitle() {
        mModel?.let {
            it.updateTitle()
            mTitle.postValue(it.title)
            mTitle.value
        }

    }

}