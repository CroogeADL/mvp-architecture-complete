package com.example.ui.home

import com.example.model.joke.ChuckNorrisJokeUi
import com.example.ui.base.BasePresenter
import com.example.ui.base.BaseView

interface HomeContract {

    interface View : BaseView<Presenter> {
        fun showJoke(uiJoke: ChuckNorrisJokeUi)
    }

    interface Presenter : BasePresenter {
        fun loadRandomJoke()
    }
}