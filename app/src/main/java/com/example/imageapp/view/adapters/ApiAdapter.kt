package com.example.imageapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imageapp.databinding.ItemListBinding
import com.example.imageapp.model.models.ApiResponse

class ApiAdapter : ListAdapter<ApiResponse, ApiAdapter.ApiViewHolder>(ApiDiffUtil) {


    class ApiViewHolder(
        val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    ){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiAdapter.ApiViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ApiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApiAdapter.ApiViewHolder, position: Int) {
        holder.binding.apply {
            val item = getItem(position)
            Glide.with(holder.itemView)
                .load(item.hits?.get(position)?.largeImageURL)
                .into(image)

        }
    }

     object ApiDiffUtil : DiffUtil.ItemCallback<ApiResponse>(){
        override fun areItemsTheSame(oldItem: ApiResponse, newItem: ApiResponse): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ApiResponse, newItem: ApiResponse): Boolean {
            return oldItem == newItem
        }

    }
}