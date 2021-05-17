package com.arno.jasmine.lib.core.mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.arno.jasmine.lib.core.mvvm.i.IActivity
import com.arno.jasmine.lib.core.mvvm.i.IView
import com.arno.jasmine.lib.util.JLog

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/14
 *     desc  : View层
 * </pre>
 */
abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel<BaseModel>> :
    AppCompatActivity(),
    IView,
    IActivity {
    protected lateinit var mBinding: B
    protected lateinit var mViewModel: VM
    abstract fun providerVMClass(): Class<VM>?

    override fun onCreate(savedInstanceState: Bundle?) {
        JLog.i(javaClass.simpleName, "onCreate")
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        super.onCreate(savedInstanceState)
        mBinding.lifecycleOwner = this
        initVM()
        initView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        JLog.d(javaClass.simpleName, "onDestroy")
        mBinding.unbind()
    }

    private fun initVM() {
        providerVMClass()?.let {
            mViewModel = ViewModelProvider(this).get(it)
        }
    }
}