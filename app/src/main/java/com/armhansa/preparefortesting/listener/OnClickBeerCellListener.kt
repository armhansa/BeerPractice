package com.armhansa.preparefortesting.listener

import com.armhansa.preparefortesting.model.BeerModel

interface OnClickBeerCellListener {
    fun onClick(beerModel: BeerModel)
}