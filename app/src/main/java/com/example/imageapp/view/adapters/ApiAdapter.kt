package com.example.imageapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imageapp.databinding.ItemListBinding
import com.example.imageapp.model.models.Hit

class ApiAdapter : ListAdapter<Hit, ApiAdapter.ApiViewHolder>(ApiDiffUtil) {


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
                .load(item.largeImageURL)
                .into(image)

        }
    }

     object ApiDiffUtil : DiffUtil.ItemCallback<Hit>(){
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem == newItem
        }

    }
}