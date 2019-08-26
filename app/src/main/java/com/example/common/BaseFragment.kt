package com.example.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.ui.base.BasePresenter
import com.example.ui.base.BaseView

abstract class BaseFragment<P : BasePresenter, B : ViewDataBinding> : Fragment(), BaseView<P> {

    protected lateinit var binding: B

    protected abstract val contentLayoutId: Int
        @LayoutRes get

    protected open val presenter: P? = null

    protected open fun setupBinding(binding: B) {}

    protected open fun setupActionBar(toolbar: Toolbar) {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

    protected open fun setupViews() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, contentLayoutId, container, false)
        binding.lifecycleOwner = this
        setupBinding(binding)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    override fun onStart() {
        super.onStart()
        presenter?.start()
    }

    protected fun showFragment(
        fragment: Fragment,
        @IdRes contentLayout: Int,
        addToBackStack: Boolean = false,
        tag: String? = null
    ) {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.replace(contentLayout, fragment, tag)
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }
}