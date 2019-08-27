package com.example.ui.home

import android.content.Context
import com.example.R
import com.example.common.BaseFragment
import com.example.databinding.FragmentHomeBinding
import com.example.model.joke.ChuckNorrisJokeUi
import java.lang.RuntimeException

class HomeFragment : BaseFragment<HomeContract.Presenter, FragmentHomeBinding>(),
    HomeContract.View,
    HomeActionListener {

    override val presenter = HomePresenter(this)

    override val contentLayoutId: Int
        get() = R.layout.fragment_home

    private var listener: HomeListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is HomeListener) {
            listener = context
        } else {
            throw RuntimeException("${context.toString()} must implement HomeListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

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

    interface HomeListener {
        fun navigateToFavoriteJokesScreen()
    }
}