package com.armhansa.preparefortesting.activity

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import com.armhansa.preparefortesting.R
import com.armhansa.preparefortesting.activity.beer.BeerFragment
import com.armhansa.preparefortesting.activity.ui.main.SectionsPagerAdapter
import com.armhansa.preparefortesting.fragment.StupidFragment
import com.armhansa.preparefortesting.model.TabModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabList: ArrayList<TabModel> = arrayListOf(
            TabModel("Stupid1", StupidFragment()),
            TabModel("BEERs", BeerFragment()),
            TabModel("Stupid3", StupidFragment())
        )

        val sectionsPagerAdapter = SectionsPagerAdapter(tabList, supportFragmentManager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }
}