package com.example.data.datasource.network.base

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseAPI(baseUrl: String, printLogs: Boolean) : API {

    protected val restAdapter: Retrofit

    private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()

    init {
        restAdapter = generateRestAdapter(baseUrl, printLogs)
    }

    private fun generateRestAdapter(baseUrl: String, printLogs: Boolean): Retrofit {
        loggingInterceptor.level =
            if (printLogs) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val baseRequestClient = OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(baseRequestClient)
            .build()
    }
}