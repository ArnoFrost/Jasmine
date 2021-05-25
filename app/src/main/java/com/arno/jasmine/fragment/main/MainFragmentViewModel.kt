package com.arno.jasmine.fragment.main

import androidx.lifecycle.MutableLiveData
import com.arno.jasmine.lib.core.mvvm.base.BaseViewModel
import org.koin.java.KoinJavaComponent.inject

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : MainFragment VM层
 * </pre>
 */
class MainFragmentViewModel : BaseViewModel<MainFragmentModel>() {
    override val mModel: MainFragmentModel? by inject(MainFragmentModel::class.java)
    val mTitle: MutableLiveData<String> = MutableLiveData("Welcome to Jasmine~")

    fun refreshTitle() {
        mModel?.let {
            it.refreshTitle()
            mTitle.postValue("$mTitle ${System.currentTimeMillis()}")
        }
    }
}