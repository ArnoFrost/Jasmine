package com.arno.jasmine.lib.core.mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModelProvider
import com.arno.jasmine.lib.common.util.JLog
import com.arno.jasmine.lib.core.mvvm.i.IActivity
import com.arno.jasmine.lib.core.mvvm.i.IView
import com.arno.jasmine.lib.util.StatusBar
import com.arno.jasmine.lib.widget.LoadingDialog

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/14
 *     desc  : View层
 * </pre>
 */
abstract class BaseActivity<B : ViewDataBinding, out VM : BaseViewModel<BaseModel>> :
    AppCompatActivity(),
    IView,
    IActivity {
    protected var mBinding: B? = null
    protected var mViewModel: @UnsafeVariance VM? = null
    abstract fun provideVMClass(): Class<@UnsafeVariance VM>?
    protected lateinit var mLoadingView: LoadingDialog
    protected var canNotCancel = false

    override fun onCreate(savedInstanceState: Bundle?) {
        JLog.i(javaClass.simpleName, "onCreate")
        StatusBar().fitSystemBar(this)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        super.onCreate(savedInstanceState)
        mBinding?.lifecycleOwner = this
        initVM()
        initView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        JLog.d(javaClass.simpleName, "onDestroy")
        mBinding?.unbind()
    }

    private fun initVM() {
        JLog.i(javaClass.simpleName, "initVM")
        provideVMClass()?.let {
            mViewModel = ViewModelProvider(this).get(it)
        }
    }

    override fun initView() {
        JLog.i(javaClass.simpleName, "initView")
    }

    override fun initData() {
        JLog.i(javaClass.simpleName, "initData")
    }

    override fun showLoadingView() {
        mLoadingView.showDialog(this, canNotCancel)
    }

    override fun hideLoadingView() {
        mLoadingView.dismissDialog()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun releaseView() {
        mLoadingView.dismissDialog()
    }
}
