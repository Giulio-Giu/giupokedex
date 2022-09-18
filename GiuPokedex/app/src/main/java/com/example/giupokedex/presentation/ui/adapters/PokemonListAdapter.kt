package com.example.giupokedex.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.giupokedex.R
import com.example.giupokedex.common.utils.GiuPokedexUtils
import com.example.giupokedex.common.utils.GiuPokedexUtils.show
import com.example.giupokedex.databinding.ItemPokemonBinding
import com.example.giupokedex.databinding.ItemRecyclerLoadingBinding
import com.example.giupokedex.domain.models.pokeapi_co.PokemonResult
import com.example.giupokedex.presentation.eventclick.EventClickItemPokemon

class PokemonListAdapter(private var searchPokemonList: ArrayList<PokemonResult>) :
    RecyclerView.Adapter<PokemonListAdapter.ItemViewHolder>() {
//  RecyclerView.Adapter<RecyclerView.ViewHolder>() {

//    private val VIEW_TYPE_ITEM = 0
//    private val VIEW_TYPE_LOADING = 1

    var eventClickItemPokemon: EventClickItemPokemon? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewBinding = ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ItemViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = searchPokemonList[position]
        holder.bindView(item, eventClickItemPokemon)
    }

    //    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return if (viewType == VIEW_TYPE_ITEM) {
//            val viewBinding = ItemPokemonBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent, false
//            )
//            ItemViewHolder(viewBinding)
//        } else {
//            val viewBinding = ItemRecyclerLoadingBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent, false
//            )
//            LoadingViewHolder(viewBinding)
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (holder is ItemViewHolder) {
//            val item = searchPokemonList[position]
//            holder.bindView(item, eventClickItemPokemon)
//        } else if (holder is LoadingViewHolder) {
//            holder.showLoadingView()
//        }
//    }

    override fun getItemCount(): Int {
        return searchPokemonList.size
    }

//    override fun getItemViewType(position: Int): Int {
//        return if ((searchPokemonList.getOrNull(position)) == null) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
//    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<PokemonResult>) {
        searchPokemonList.addAll(newList)
        this.notifyDataSetChanged()
    }

    fun addItem(newItem: PokemonResult?) {
        searchPokemonList.plus(newItem)
        this.notifyItemInserted(searchPokemonList.size - 1)
    }

    inner class ItemViewHolder(private val viewBinding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bindView(
            item: PokemonResult,
            eventClickItemPokemon: EventClickItemPokemon?
        ) {
            viewBinding.apply {
                itemNumberName.text = item.getItemPokemonNumberAndName()

                itemImage.load(item.getImageUrl()) {
                    listener(
                        onSuccess = { _, _ ->
                            itemProgressBarImage.hide()
                            itemImage.show()
                            itemImage.scaleType = ImageView.ScaleType.CENTER_INSIDE
                            itemCardView.setBackgroundColor(GiuPokedexUtils.getRandomColor())
                        },
                        onError = { _, _ ->
                            itemProgressBarImage.hide()
                            itemImage.apply {
                                show()
                                scaleType = ImageView.ScaleType.FIT_CENTER
                                setImageResource(R.drawable.ic_error_outline_24)
                            }
                        }
                    )
                }

                itemCardView.setOnClickListener {
                    eventClickItemPokemon?.onClickItemPokemon(item.name)
                }
            }
        }
    }

//    inner class LoadingViewHolder(private val viewBinding: ItemRecyclerLoadingBinding) :
//        RecyclerView.ViewHolder(viewBinding.root) {
//        fun showLoadingView() {
//            viewBinding.itemLoadingProgressBar.show()
//        }
//    }
}