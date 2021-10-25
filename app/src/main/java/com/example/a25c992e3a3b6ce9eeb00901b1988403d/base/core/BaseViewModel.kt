package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(private val repository: BaseRepository) : ViewModel(),
    CoroutineScope {

    val httpClient
        get() = repository.httpClient

    val database
        get() = repository.database


    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    abstract fun init()
}