package com.example.candidatetestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewPagerAdapter: MainViewPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.main_tablayout)
        viewPager = findViewById(R.id.main_viewpager)
        viewPager.offscreenPageLimit = 2

        mainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = mainViewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position){
                0 -> {
                    tab.text = "Greeter"
                }
                1 -> {
                    tab.text = "Gallery"
                }
            }
        }
    }
}