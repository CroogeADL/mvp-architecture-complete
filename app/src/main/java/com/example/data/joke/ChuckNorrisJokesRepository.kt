package com.example.data.joke

import com.example.data.datasource.network.NetworkDataSource
import com.example.data.datasource.network.base.ResultData
import com.example.model.joke.ChuckNorrisJoke

class ChuckNorrisJokesRepository(private val networkDataSource: NetworkDataSource) :
    RepositoryChuckNorrisJokes {

    override fun getRandomJoke(): ResultData<ChuckNorrisJoke> =
        networkDataSource.chuckNorrisJokesModule().getRandomJoke()

    override fun getRandomJokeAsync(onResult: (resultData: ResultData<ChuckNorrisJoke>) -> Unit) =
        networkDataSource.chuckNorrisJokesModule().getRandomJokeAsync(onResult)
}