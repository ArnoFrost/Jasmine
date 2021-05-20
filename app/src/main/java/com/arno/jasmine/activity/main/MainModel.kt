package com.arno.jasmine.activity.main

import com.arno.jasmine.lib.core.mvvm.base.BaseModel
import com.arno.jasmine.lib.data.IDataRepository
import javax.inject.Inject

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  :
 * </pre>
 */
class MainModel @Inject constructor(mDataRepository: IDataRepository?) :
    BaseModel(mDataRepository) {
    var title: String? = ""

    fun updateTitle() {
        title = "This is request title ${System.currentTimeMillis()}"
    }

    override fun released() {

    }
}