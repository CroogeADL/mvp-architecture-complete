package com.example.mapper.joke

import com.example.model.joke.ChuckNorrisJokeUi
import com.example.model.joke.ChuckNorrisJoke
import com.example.mapper.Mapper

class ChuckNorrisJokeToChuckNorrisJokeUiMapper : Mapper<ChuckNorrisJoke, ChuckNorrisJokeUi> {
    override fun map(model: ChuckNorrisJoke) = ChuckNorrisJokeUi(model.joke)
}