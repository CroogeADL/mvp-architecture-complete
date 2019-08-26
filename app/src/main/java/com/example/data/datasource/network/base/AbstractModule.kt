package com.example.data.datasource.network.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

abstract class AbstractModule<T>(protected val service: T) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}