package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.BR

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {
    protected lateinit var mRootView: View
    protected lateinit var mBinding: T
    protected lateinit var mViewModel: V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewModel = getViewModel()
        mBinding = getBinding()
        mRootView = mBinding.root
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.setVariable(BR.vm, mViewModel)
        mBinding.lifecycleOwner = this
        mBinding.executePendingBindings()
        initUI()
    }

    open fun initUI(){
        //Empty body}
    }

    abstract fun getBinding(): T

    abstract fun getViewModel(): V
}