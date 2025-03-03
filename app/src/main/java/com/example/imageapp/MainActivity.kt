package com.example.imageapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.imageapp.databinding.ActivityMainBinding
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
        viewModel.getImages("49085045-188b342da441f8a6e1476a6e9", "red")
        viewModel.getWhether("cf21bdf785394d0bb0a72455250702", "Bishkek")
        binding.apply {
            recyclerView.adapter = adapter
            viewModel.images.observe(this@MainActivity) { response ->
                adapter.submitList(response.hits)
            }

            viewModel.weather.observe(this@MainActivity) { response ->
                textView.text = response.current?.tempC.toString()
            }
        }
    }
}