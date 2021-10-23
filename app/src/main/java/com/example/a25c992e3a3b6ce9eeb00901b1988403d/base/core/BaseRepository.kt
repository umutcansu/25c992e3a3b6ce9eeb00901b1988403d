package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core

import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.AppDatabase
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.retrofit.RetrofitService
import javax.inject.Inject

class BaseRepository  constructor(
     val httpClient: RetrofitService,
     val database: AppDatabase
)