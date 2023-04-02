package com.srhdp.newapimvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.srhdp.newapimvvm.databinding.ActivityMainBinding
import com.srhdp.newapimvvm.presentation.viewmodel.NewsViewModel
import com.srhdp.newapimvvm.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: NewsViewModelFactory
    lateinit var viewModel:NewsViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvNews.setupWithNavController(navController)

        viewModel = ViewModelProvider(this,factory)
            .get(NewsViewModel::class.java)
    }
}