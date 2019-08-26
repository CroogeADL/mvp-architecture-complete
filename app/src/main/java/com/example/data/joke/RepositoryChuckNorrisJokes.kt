package com.example.data.joke

import com.example.data.datasource.network.base.ResultData
import com.example.model.joke.ChuckNorrisJoke

interface RepositoryChuckNorrisJokes {
    fun getRandomJoke(): ResultData<ChuckNorrisJoke>
    fun getRandomJokeAsync(onResult: (resultData: ResultData<ChuckNorrisJoke>) -> Unit)
}