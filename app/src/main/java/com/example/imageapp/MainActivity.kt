package com.example.imageapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imageapp.databinding.ActivityMainBinding
import com.example.imageapp.model.core.Either
import com.example.imageapp.view.adapters.ApiAdapter
import com.example.imageapp.viewmodel.ApiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter = ApiAdapter()

    private val viewModel: ApiViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        binding.apply {
            recyclerView.adapter = adapter
            viewModel.images.observe(this@MainActivity) { response ->
                adapter.submitList(listOf(response))
            }

        }
    }
}