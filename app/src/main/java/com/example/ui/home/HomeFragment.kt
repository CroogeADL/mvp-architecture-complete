package com.example.ui.home

import com.example.R
import com.example.common.BaseFragment
import com.example.databinding.FragmentHomeBinding
import com.example.model.joke.ChuckNorrisJokeUi

class HomeFragment : BaseFragment<HomeContract.Presenter, FragmentHomeBinding>(),
    HomeContract.View,
    HomeActionListener {

    override val presenter: HomeContract.Presenter
        get() = HomePresenter(this)

    override val contentLayoutId: Int
        get() = R.layout.fragment_home

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun setupBinding(binding: FragmentHomeBinding) {
        binding.listener = this
    }

    override fun onNextClicked() {
        presenter.loadRandomJoke()
    }

    override fun showJoke(uiJoke: ChuckNorrisJokeUi) {
        binding.tvJoke.text = uiJoke.joke
    }
}