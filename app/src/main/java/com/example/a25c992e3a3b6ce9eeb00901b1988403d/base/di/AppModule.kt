package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.di

import android.content.Context
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.AppDatabase
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.retrofit.RetrofitHelper
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.retrofit.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @ViewModelScoped
    @Provides
    fun injectDatabase(@ApplicationContext context: Context) = AppDatabase(context)

    @ViewModelScoped
    @Provides
    fun injectRetrofit():RetrofitService{
        return  RetrofitHelper.Call
    }

    @ViewModelScoped
    @Provides
    fun injectRepository(httpClient: RetrofitService,
                          database: AppDatabase ): BaseRepository {
        return BaseRepository(httpClient,database)
    }
}