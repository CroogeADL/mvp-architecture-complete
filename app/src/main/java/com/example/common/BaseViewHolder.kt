package com.example.common

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<B : ViewDataBinding, T>(protected val binding: B) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: T)
}