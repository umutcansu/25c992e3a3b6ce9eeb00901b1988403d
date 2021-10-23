package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.retrofit

import com.example.a25c992e3a3b6ce9eeb00901b1988403d.model.SpaceStationItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("e7211664-cbb6-4357-9c9d-f12bf8bab2e2")
    fun getSpaceShuttle(
    ): Call<List<SpaceStationItem>>
}