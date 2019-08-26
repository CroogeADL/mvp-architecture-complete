package com.example.common

import android.view.View
import android.widget.TextView
import androidx.annotation.FontRes
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.res.ResourcesCompat

@BindingConversion
fun convertBooleanToVisibility(visible: Boolean): Int {
    return if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("adapter")
fun <T, B : ViewDataBinding, VH : BaseViewHolder<B, T>> setAdapter(
    recyclerView: RecyclerView,
    adapter: BaseRecyclerAdapter<T, B, VH>?
) {
    adapter?.let { recyclerView.adapter = it }
}

@BindingAdapter("font")
fun setFont(
    textView: TextView,
    @FontRes fontId: Int
) {
    val typeface = ResourcesCompat.getFont(textView.context, fontId)
    textView.typeface = typeface
}