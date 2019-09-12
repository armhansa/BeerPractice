package com.armhansa.preparefortesting.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.armhansa.preparefortesting.R
import com.armhansa.preparefortesting.listener.OnClickBeerCellListener
import com.armhansa.preparefortesting.model.BeerModel
import com.squareup.picasso.Picasso

class BeerAdapter(private val listener: OnClickBeerCellListener) : RecyclerView.Adapter<BeerViewHolder>() {
    private var beerList: ArrayList<BeerModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder = BeerViewHolder(parent)

    override fun getItemCount(): Int {
        return beerList.count()
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.bind(beerList[position], listener)
    }

    fun addNewBeerItems(beerList: List<BeerModel>) {
        this.beerList.addAll(beerList)
        notifyDataSetChanged()
    }

}

class BeerViewHolder(private val parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_beer, parent, false)
) {
    private val beerName: TextView = itemView.findViewById(R.id.beerName)
    private val beerImage: ImageView = itemView.findViewById(R.id.beerImage)
    private val beerDesc: TextView = itemView.findViewById(R.id.beerDesc)

    fun bind(beerModel: BeerModel, listener: OnClickBeerCellListener) {
        beerName.text = "${beerModel.name} : ABV=${beerModel.abv}%"
        Picasso.with(parent.context).load(beerModel.imageUrl).into(beerImage)
        beerDesc.text = beerModel.description
        itemView.setOnClickListener {
            listener.onClick(beerModel)
        }
    }

}
