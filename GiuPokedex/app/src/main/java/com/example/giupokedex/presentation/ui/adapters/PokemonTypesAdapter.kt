package com.example.giupokedex.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.giupokedex.common.utils.GiuPokedexUtils
import com.example.giupokedex.databinding.ItemPokemonTypeBinding

class PokemonTypesAdapter(private var listTypes: ArrayList<String>) :
    RecyclerView.Adapter<PokemonTypesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemPokemonTypeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemUrl = listTypes[position]
        if (itemUrl.trim().isNotEmpty()) holder.bindView(itemUrl)
    }

    override fun getItemCount(): Int {
        return listTypes.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<String>) {
        listTypes = newList
        this.notifyDataSetChanged()
    }

    inner class ViewHolder(private val viewBinding: ItemPokemonTypeBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bindView(typeName: String) {
            viewBinding.apply {
                pokemonTypeText.apply {
                    text = typeName.replaceFirstChar(Char::titlecase)
                    setTextColor(GiuPokedexUtils.getTypeColorOrId(typeName, isColor = true))
                }
                pokemonTypeIcon.setImageResource(
                    GiuPokedexUtils.getTypeColorOrId(
                        typeName,
                        isColor = false
                    )
                )
            }
        }
    }
}