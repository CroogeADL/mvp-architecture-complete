package com.example.data.datasource.network

import com.example.BuildConfig
import com.example.common.DEFAULT_ERROR_MESSAGE
import com.example.common.getErrorMessage
import com.example.data.datasource.network.base.BaseAPI
import com.example.data.datasource.network.base.ResponseData
import com.example.data.datasource.network.base.ResultData
import com.example.data.datasource.network.joke.ChuckNorrisJokesModule
import com.example.data.datasource.network.joke.ChuckNorrisJokesService
import com.example.mapper.Mapper
import retrofit2.Call
import java.lang.Exception

private const val API_ENDPOINT = "https://api.icndb.com/jokes/"

class NetworkDataSource : BaseAPI(API_ENDPOINT, printLogs = BuildConfig.DEBUG) {

    override fun chuckNorrisJokesModule() =
        ChuckNorrisJokesModule(restAdapter.create(ChuckNorrisJokesService::class.java))
}

fun <T> Call<T>.execute(): ResultData<T> {
    return try {
        val response = execute()
        if (response.isSuccessful) {
            ResultData(response.body(), null)
        } else {
            ResultData(null, response.errorBody()?.string() ?: DEFAULT_ERROR_MESSAGE)
        }
    } catch (e: Exception) {
        ResultData(null, e.getErrorMessage())
    }
}

fun <T, R> Call<ResponseData<T>>.execute(mapper: Mapper<T, R>): ResultData<R> {
    return try {
        val response = execute()
        if (response.isSuccessful) {
            ResultData(response.body()?.value?.let { mapper.map(it) }, null)
        } else {
            ResultData(null, response.errorBody()?.string() ?: DEFAULT_ERROR_MESSAGE)
        }
    } catch (e: Exception) {
        ResultData(null, e.getErrorMessage())
    }
}