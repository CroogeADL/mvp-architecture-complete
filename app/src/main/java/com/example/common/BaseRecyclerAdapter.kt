package com.example.common

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, B : ViewDataBinding, VH : BaseViewHolder<B, T>>(protected val dataList: List<T>) :
    RecyclerView.Adapter<VH>() {

    override fun getItemCount() = dataList.size

    fun add(index: Int = -1, item: T) {
        if (dataList is MutableList<T>) {
            when {
                index > -1 -> {
                    dataList.add(index, item)
                    notifyItemInserted(index)
                }
                else -> {
                    dataList.add(item)
                    notifyItemInserted(dataList.size - 1)
                }
            }
        }
    }

    fun remove(index: Int = -1, item: T) {
        if (dataList is MutableList<T>) {
            dataList.remove(item)
            takeIf { index > -1 }.apply { notifyItemRemoved(index) } ?: notifyDataSetChanged()
        }
    }
}