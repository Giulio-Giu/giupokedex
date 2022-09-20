package com.example.giupokedex.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.giupokedex.common.utils.GiuPokedexUtils
import com.example.giupokedex.common.utils.GiuPokedexUtils.getTextInitialCap
import com.example.giupokedex.databinding.ItemPokemonTypeBinding
import com.example.giupokedex.domain.models.pokeapi_co.base.Type
import com.example.giupokedex.presentation.eventclick.EventClickItemPokemonType

class PokemonTypesAdapter(private var listPokemonTypes: ArrayList<Type>) :
    RecyclerView.Adapter<PokemonTypesAdapter.ViewHolder>() {

    var eventClickItemPokemonType: EventClickItemPokemonType? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemPokemonTypeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listPokemonTypes[position]
        if (item.name.trim().isNotEmpty()) holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return listPokemonTypes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<Type>) {
        listPokemonTypes = newList
        this.notifyDataSetChanged()
    }

    inner class ViewHolder(private val viewBinding: ItemPokemonTypeBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bindView(type: Type) {
            viewBinding.apply {
                pokemonTypeText.apply {
                    text = type.name.getTextInitialCap()
                    setTextColor(GiuPokedexUtils.getTypeColorOrId(type.name, isColor = true))
                }
                pokemonTypeIcon.setImageResource(
                    GiuPokedexUtils.getTypeColorOrId(
                        type.name,
                        isColor = false
                    )
                )
                pokemonTypeContainer.setOnClickListener {
                    eventClickItemPokemonType?.onClickItemPokemonType(type)
                }
            }
        }
    }
}