package com.example.giupokedex.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.giupokedex.R
import com.example.giupokedex.databinding.ItemPokemonPictureBinding

class PokemonPicturesAdapter(private var listImages: ArrayList<String>) :
    RecyclerView.Adapter<PokemonPicturesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemPokemonPictureBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemUrl = listImages[position]
        if (itemUrl.trim().isNotEmpty()) holder.bindView(itemUrl)
    }

    override fun getItemCount(): Int {
        return listImages.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<String>) {
        listImages = newList
        this.notifyDataSetChanged()
    }

    inner class ViewHolder(private val viewBinding: ItemPokemonPictureBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bindView(imageUrl: String) {

            val options = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.drawable.ic_error_outline_24)

            Glide.with(viewBinding.root).load(imageUrl).apply(options)
                .into(viewBinding.ivPicturePokemon)
        }
    }
}