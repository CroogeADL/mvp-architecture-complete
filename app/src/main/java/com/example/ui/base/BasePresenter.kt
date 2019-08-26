package com.example.ui.base

import com.example.data.RepositoryImpl

interface BasePresenter {

    fun start()

    fun getRepository() = RepositoryImpl.getInstance()
}