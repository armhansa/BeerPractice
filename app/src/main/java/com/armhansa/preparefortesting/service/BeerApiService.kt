package com.armhansa.preparefortesting.service

import com.armhansa.preparefortesting.model.BeerModel
import retrofit2.Call
import retrofit2.http.GET

interface BeerApiService {
    @GET("beers/")
    fun getBeers() : Call<List<BeerModel>>
}