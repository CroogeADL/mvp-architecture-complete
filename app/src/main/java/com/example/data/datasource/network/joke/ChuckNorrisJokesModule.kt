package com.example.data.datasource.network.joke

import com.example.data.datasource.network.base.ResultData
import com.example.data.datasource.network.execute
import com.example.data.datasource.network.base.AbstractModule
import com.example.model.joke.ChuckNorrisJoke
import com.example.mapper.joke.ChuckNorrisJokeResponseToChuckNorrisJokeMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChuckNorrisJokesModule(service: ChuckNorrisJokesService) :
    AbstractModule<ChuckNorrisJokesService>(service),
    ModuleChuckNorrisJokes {

    override fun getRandomJoke(): ResultData<ChuckNorrisJoke> =
        getRandomJokeCall().execute(ChuckNorrisJokeResponseToChuckNorrisJokeMapper())

    override fun getRandomJokeAsync(onResult: (resultData: ResultData<ChuckNorrisJoke>) -> Unit) {
        launch {
            val response = withContext(Dispatchers.IO) {
                getRandomJokeCall().execute(ChuckNorrisJokeResponseToChuckNorrisJokeMapper())
            }
            onResult(response)
        }
    }

    private fun getRandomJokeCall() = service.getRandomJoke()
}