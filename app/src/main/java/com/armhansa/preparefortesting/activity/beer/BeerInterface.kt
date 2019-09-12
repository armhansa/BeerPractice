package com.armhansa.preparefortesting.activity.beer

import com.armhansa.preparefortesting.model.BeerModel

interface BeerInterface {
    fun setBeer(beerList: List<BeerModel>)
    fun alertError(t: Throwable)
}