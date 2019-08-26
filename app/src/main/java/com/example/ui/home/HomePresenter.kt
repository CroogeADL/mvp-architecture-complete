package com.example.ui.home

import com.example.mapper.joke.ChuckNorrisJokeToChuckNorrisJokeUiMapper

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {

    override fun start() {
        loadRandomJoke()
    }

    override fun loadRandomJoke() {
        getRepository().getRandomJokeAsync { result ->
            result.data?.let { joke ->
                view.showJoke(ChuckNorrisJokeToChuckNorrisJokeUiMapper().map(joke))
            }
        }
    }
}