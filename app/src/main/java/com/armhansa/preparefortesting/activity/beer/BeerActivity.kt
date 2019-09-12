package com.armhansa.preparefortesting.activity.beer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.armhansa.preparefortesting.R
import com.armhansa.preparefortesting.activity.BeerDetailActivity
import com.armhansa.preparefortesting.listener.OnClickBeerCellListener
import com.armhansa.preparefortesting.adapter.BeerAdapter
import com.armhansa.preparefortesting.model.BeerModel
import kotlinx.android.synthetic.main.activity_beer.*

class BeerActivity : AppCompatActivity(), OnClickBeerCellListener,
    BeerInterface {
    private lateinit var beerAdapter: BeerAdapter

    private val beerPresenter: BeerPresenter =
        BeerPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer)

        beerAdapter = BeerAdapter(this)
        rvTodo.adapter = beerAdapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        beerPresenter.getBeers()
//        rvTodo.itemAnimator = DefaultItemAnimator()

//        btnAdd.setOnClickListener {
//            inputTodo.text?.let {
//                if (it.isNotEmpty()) {
//                    val todoModel = TodoModel(it.toString(), false)
//                    beerAdapter.addNewBeerItems(todoModel)
//                    inputTodo.text = null
//                }
//            }
//        }

    }

    override fun onClick(beerModel: BeerModel) {
        BeerDetailActivity.startActivity(this, beerModel)
    }

    override fun alertError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
    }

    override fun setBeer(beerList: List<BeerModel>) {
        beerAdapter.addNewBeerItems(beerList)
    }

}
