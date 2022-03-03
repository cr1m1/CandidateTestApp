package com.example.candidatetestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.candidatetestapp.databinding.ActivityMainBinding
import com.example.candidatetestapp.viewmodel.DataViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.mainBottomNav)
        val actionBar = supportActionBar
        actionBar?.title = "Profile"
        openFragment(GreeterFragment())

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.greeter_item -> {
                    actionBar?.title = "Profile"
                    openFragment(GreeterFragment())
                    true
                }
                R.id.gallery_item -> {
                    actionBar?.title = "Gallery"
                    openFragment(GalleryFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment)
            .commit()
    }
}