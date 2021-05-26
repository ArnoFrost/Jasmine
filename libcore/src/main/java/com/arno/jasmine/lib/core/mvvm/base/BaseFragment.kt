package com.arno.jasmine.lib.core.mvvm.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModelProvider
import com.arno.jasmine.lib.common.util.JLog
import com.arno.jasmine.lib.core.mvvm.i.IFragment
import com.arno.jasmine.lib.core.mvvm.i.IView
import com.arno.jasmine.lib.widget.LoadingDialog

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : Fragment层 可通过懒加载控制,采用AndroidX的控制方法
 *     外部通过[FragmentTransaction.setMaxLifecycle(Fragment, Lifecycle.State)]
 * </pre>
 */
abstract class BaseFragment<B : ViewDataBinding, out VM : BaseViewModel<BaseModel>> :
    Fragment(),
    IView,
    IFragment {
    private lateinit var mContext: Context
    protected var mBinding: B? = null
    protected var mViewModel: @UnsafeVariance VM? = null
    abstract fun providerVMClass(): Class<@UnsafeVariance VM>?
    protected lateinit var mLoadingView: LoadingDialog
    protected var canNotCancel = false

    //数据是否加载标识
    private var isLoaded = false

    /**
     * 是否懒加载
     *
     */
    protected open fun lazyLoad() = false

    /**
     * 是否fragment显示的时候都重新加载数据
     */
    protected open fun reLoad() = false
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mLoadingView = LoadingDialog(view.context, canNotCancel)
        if (!lazyLoad()) {
            initVM()
            initView()
        }
    }

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            lazyInit()
            isLoaded = true
        } else if (reLoad()) {
            initData()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), null, false)
        mBinding?.lifecycleOwner = this
        return mBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding?.unbind()
        isLoaded = false
    }

    override fun lazyInit() {
        initVM()
        initView()
        initData()
    }


    private fun initVM() {
        JLog.i(javaClass.simpleName, "initVM")
        providerVMClass()?.let {
            mViewModel = ViewModelProvider(this).get(it)
        }
    }

    override fun showLoadingView() {
        mLoadingView.showDialog(mContext, canNotCancel)
    }

    override fun hideLoadingView() {
        mLoadingView.dismissDialog()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun releaseView() {
        mLoadingView.dismissDialog()
    }
}