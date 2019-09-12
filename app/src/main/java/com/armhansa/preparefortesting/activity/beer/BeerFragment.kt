package com.armhansa.preparefortesting.activity.beer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.armhansa.preparefortesting.R
import com.armhansa.preparefortesting.activity.BeerDetailActivity
import com.armhansa.preparefortesting.listener.OnClickBeerCellListener
import com.armhansa.preparefortesting.adapter.BeerAdapter
import com.armhansa.preparefortesting.model.BeerModel
import kotlinx.android.synthetic.main.activity_beer.*

class BeerFragment : Fragment(), OnClickBeerCellListener,
    BeerInterface {
    private lateinit var beerAdapter: BeerAdapter

    private val beerPresenter: BeerPresenter =
        BeerPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.activity_beer, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        beerAdapter = BeerAdapter(this)
        rvTodo.adapter = beerAdapter
        rvTodo.layoutManager = LinearLayoutManager(context)

        beerPresenter.getBeers()
//        rvTodo.itemAnimator = DefaultItemAnimator()
    }

    override fun onClick(beerModel: BeerModel) {
        BeerDetailActivity.startActivity(context, beerModel)
    }

    override fun alertError(t: Throwable) {
        Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
    }

    override fun setBeer(beerList: List<BeerModel>) {
        beerAdapter.addNewBeerItems(beerList)
    }

}
