package com.example.data.datasource.network.base

import com.example.data.datasource.network.joke.ModuleChuckNorrisJokes

interface API {
    fun chuckNorrisJokesModule(): ModuleChuckNorrisJokes
}