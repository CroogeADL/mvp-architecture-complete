package com.example.data.datasource.network.joke

import com.example.data.datasource.network.base.ResultData
import com.example.model.joke.ChuckNorrisJoke

interface ModuleChuckNorrisJokes {
    fun getRandomJoke(): ResultData<ChuckNorrisJoke>
    fun getRandomJokeAsync(onResult: (resultData: ResultData<ChuckNorrisJoke>) -> Unit)
}
