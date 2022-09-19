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

    override fun getItemCount(): Int {
        return searchPokemonList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<PokemonResult>) {
        searchPokemonList.addAll(newList)
        this.notifyDataSetChanged()
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
                    eventClickItemPokemon?.onClickItemPokemon(item.getPokemonNumber())
                }
            }
        }
    }
}