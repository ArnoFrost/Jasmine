package com.arno.jasmine.fragment.main

import com.arno.jasmine.lib.core.mvvm.base.BaseModel
import com.arno.jasmine.lib.data.DataRepository

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : MainFragment Model层
 * </pre>
 */
class MainFragmentModel(mDataRepository: DataRepository) :
    BaseModel(mDataRepository) {
    var title: String? = ""

    fun refreshTitle() {
        title = "This is request title ${System.currentTimeMillis()}"
    }

    override fun released() {
        title = null
    }
}