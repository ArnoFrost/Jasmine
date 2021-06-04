package com.arno.jasmine.activity.main

import com.arno.jasmine.lib.core.mvvm.base.BaseModel
import com.arno.jasmine.lib.data.DataRepository

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : MainActivity model层
 * </pre>
 */
class MainModel(mDataRepository: DataRepository) :
    BaseModel(mDataRepository) {
    override fun released() {
    }
}
