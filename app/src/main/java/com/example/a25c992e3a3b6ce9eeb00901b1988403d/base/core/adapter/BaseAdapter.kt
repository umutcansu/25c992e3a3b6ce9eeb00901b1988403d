package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseViewModel

abstract class BaseAdapter<D, VH : BaseViewHolder<ViewDataBinding>, VM : BaseViewModel> : RecyclerView.Adapter<BaseViewHolder<ViewDataBinding>>() {

    var dataSource = arrayListOf<D>()
    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding>, position: Int) {
        bind(holder.binding, position, dataSource[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewDataBinding> {
        return getViewHolder(parent, viewType)
    }

    open fun getViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder(createBinding(parent, viewType))
    abstract fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding
    protected abstract fun bind(binding: ViewDataBinding, position: Int, d: D)

    fun getItem(position: Int) = dataSource[position]
    override fun getItemCount() = dataSource.size
}