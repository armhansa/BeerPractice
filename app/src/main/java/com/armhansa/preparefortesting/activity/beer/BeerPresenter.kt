package com.armhansa.preparefortesting.activity.beer

import com.armhansa.preparefortesting.model.BeerModel
import com.armhansa.preparefortesting.service.BeerManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeerPresenter(var view: BeerInterface) {

    fun getBeers() {
        BeerManager().createService().getBeers().enqueue(object: Callback<List<BeerModel>> {
            override fun onFailure(call: Call<List<BeerModel>>, t: Throwable) {
                view.alertError(t)
            }

            override fun onResponse(call: Call<List<BeerModel>>, response: Response<List<BeerModel>>) {
                response.body()?.apply {
                    if (this.isNotEmpty()) {
                        view.setBeer(this)
                    }
                }
            }

        })
    }
}