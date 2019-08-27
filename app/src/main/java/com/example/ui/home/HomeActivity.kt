package com.example.ui.home

import com.example.R
import com.example.common.BaseActivity

class HomeActivity : BaseActivity(), HomeFragment.HomeListener {

    override val contentLayoutId: Int
        get() = R.layout.layout_container

    override val fragmentLayout: Int?
        get() = R.id.fl_content

    override val fragmentForLayout = HomeFragment.newInstance()

    override fun navigateToFavoriteJokesScreen() {
        //todo example for navigation between screens
    }
}
