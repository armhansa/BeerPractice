package com.armhansa.preparefortesting.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.armhansa.preparefortesting.R
import com.armhansa.preparefortesting.model.BeerModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class BeerDetailActivity : AppCompatActivity() {

    companion object {
        private const val TODO_TITLE_KEY = "BeerModelKey"

        fun startActivity(context: Context, beerModel: BeerModel) {
            context.startActivity(Intent(context, BeerDetailActivity::class.java).also { intent ->
                intent.putExtra(TODO_TITLE_KEY, beerModel)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val beerModel: BeerModel = intent.getParcelableExtra(TODO_TITLE_KEY)
        beerModel.name?.let {
            beerName.text = "${beerModel.name} : ABV=${beerModel.abv}%"
            Picasso.with(this).load(beerModel.imageUrl).into(beerImage)
            beerDesc.text = beerModel.description
        }
    }

}
