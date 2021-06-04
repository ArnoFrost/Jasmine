package com.arno.jasmine.lib.core.mvvm.i

import androidx.annotation.LayoutRes

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : Fragment层对接
 * </pre>
 */
interface IFragment {
    @LayoutRes
    fun getLayoutId(): Int

    fun initView()

    fun initData()

    fun lazyInit()
}
