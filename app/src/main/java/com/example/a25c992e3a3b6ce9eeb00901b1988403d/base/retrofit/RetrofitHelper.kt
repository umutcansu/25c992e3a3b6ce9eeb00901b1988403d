package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitHelper
{
    private var retrofit : Retrofit? = null

    private var  service : RetrofitService? = null

    private var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private const val  BASE_URL = "https://run.mocky.io/v3/"

    private val Client : Retrofit?
        get()
        {
            if(retrofit == null)
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit
        }


    val Call : RetrofitService
        get()
        {
            if(service == null)
                service =  Client!!.create(
                    RetrofitService::class.java)

            return service!!
        }
}