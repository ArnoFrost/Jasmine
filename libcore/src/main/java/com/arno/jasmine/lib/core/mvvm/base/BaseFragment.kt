package com.arno.jasmine.lib.core.mvvm.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.arno.jasmine.lib.core.mvvm.i.IFragment
import com.arno.jasmine.lib.core.mvvm.i.IView

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : Fragment层
 * </pre>
 */
abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel<BaseModel>> :
    Fragment(),
    IView,
    IFragment {
    protected lateinit var mContext: Context
    protected lateinit var mBinding: B
    protected lateinit var mViewModel: VM
    abstract fun providerVMClass(): Class<VM>?

    //数据是否加载标识
    private var isDataInitiated = false

    //view是否加载标识
    private var isViewInitiated = false

    //fragment是否显示
    private var isVisibleToUser = false

    /**
     * 是否懒加载
     * true:是
     * false:不(默认)
     */
    protected open fun lazyLoad() = false

    /**
     * 是否fragment显示的时候都重新加载数据
     */
    protected open fun reLoad() = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mContext = activity ?: throw Exception("activity is null")
        initVM()
        initView()
        //判断是否懒加载
        if (lazyLoad()) {
            //将view加载的标识设置为true
            isViewInitiated = true
            prepareData()
        } else {
            initData()
        }
    }

    /**
     * fragment是否显示当前界面
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        prepareData()
    }

    /**
     * 懒加载的方法
     */
    private fun prepareData() {
        //通过判断各种标识去进行数据加载
        if (isVisibleToUser && isViewInitiated && !isDataInitiated) {
            initData()
            if (reLoad()) return
            isDataInitiated = true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), null, false)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    private fun initVM() {
        providerVMClass()?.let {
            mViewModel = ViewModelProvider(this).get(it)
        }
    }
}