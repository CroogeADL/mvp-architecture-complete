package com.example.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val contentLayoutId: Int
        @LayoutRes get

    protected open val fragmentLayout: Int? = null

    protected open val fragmentForLayout: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(contentLayoutId)
        startFragment()
    }

    private fun startFragment() {
        fragmentLayout?.let { fragmentLayout ->
            val fragmentManager = supportFragmentManager
            fragmentForLayout?.let { fragment ->
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(fragmentLayout, fragment)
                fragmentTransaction.commit()
            }
        }
    }
}