package com.arno.jasmine.activity.main

import com.arno.jasmine.lib.core.mvvm.base.BaseModel

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  :
 * </pre>
 */
class MainModel(mDataRepository: MainRepository) :
    BaseModel(mDataRepository) {
    var title: String? = ""

    fun updateTitle() {
        title = "This is request title ${System.currentTimeMillis()}"
    }

    override fun released() {

    }
}