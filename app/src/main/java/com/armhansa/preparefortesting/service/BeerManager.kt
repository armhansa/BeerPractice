package com.armhansa.preparefortesting.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeerManager {
    companion object {
        private const val BASE_BEER_API = "https://api.punkapi.com/v2/"
    }

    fun createService(): BeerApiService =
        Retrofit.Builder()
            .baseUrl(BASE_BEER_API).addConverterFactory(GsonConverterFactory.create())
            .build()
            .run { create(BeerApiService::class.java) }

}