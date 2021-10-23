package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(application: Application) : AndroidViewModel(application),
    CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    val database: AppDatabase
        get() = AppDatabase(getApplication())

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}