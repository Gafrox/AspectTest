package com.example.aspecttest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aspecttest.App
import com.example.aspecttest.R
import com.example.aspecttest.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {
    private val navigatorHolder = App.INSTANCE.navigatorHolder
    private val navigator = AppNavigator(this, R.id.container)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}