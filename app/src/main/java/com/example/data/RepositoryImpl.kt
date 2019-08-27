package com.example.data

import android.content.Context
import com.example.data.datasource.network.NetworkDataSource
import com.example.data.joke.ChuckNorrisJokesRepository
import com.example.data.joke.RepositoryChuckNorrisJokes
import java.lang.RuntimeException

class RepositoryImpl constructor(private val chuckNorrisJokesRepository: RepositoryChuckNorrisJokes) :
    Repository,
    RepositoryChuckNorrisJokes by chuckNorrisJokesRepository {

    companion object {
        @Volatile
        private var INSTANCE: Repository? = null

        fun initRepository(context: Context) {
            if (INSTANCE == null) {
                synchronized(this) {
                    //todo use context for initialization another data sources like Shared Preferences, DB etc.
                    val networkDataSource = NetworkDataSource()

                    //todo init all repositories
                    val chuckNorrisJokesRepository = ChuckNorrisJokesRepository(networkDataSource)

                    RepositoryImpl(chuckNorrisJokesRepository).also { INSTANCE = it }
                }
            }
        }

        fun getInstance() = INSTANCE ?: throw RuntimeException("Repository must be initialized!")
    }
}