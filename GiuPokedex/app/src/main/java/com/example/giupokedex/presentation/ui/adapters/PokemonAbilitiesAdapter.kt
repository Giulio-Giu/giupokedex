package com.example.giupokedex.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.giupokedex.common.utils.GiuPokedexUtils.getTextInitialCap
import com.example.giupokedex.databinding.ItemPokemonAbilityBinding
import com.example.giupokedex.domain.models.pokeapi_co.base.Ability
import com.example.giupokedex.presentation.eventclick.EventClickItemPokemonAbility

class PokemonAbilitiesAdapter(private var listPokemonAbilities: ArrayList<Ability>) :
    RecyclerView.Adapter<PokemonAbilitiesAdapter.ViewHolder>() {

    var eventClickItemPokemonAbility: EventClickItemPokemonAbility? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemPokemonAbilityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listPokemonAbilities[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return listPokemonAbilities.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<Ability>) {
        listPokemonAbilities = newList
        this.notifyDataSetChanged()
    }

    inner class ViewHolder(private val viewBinding: ItemPokemonAbilityBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bindView(ability: Ability) {
            viewBinding.apply {
                itemAbilityTitle.text = ability.name.getTextInitialCap()
                itemAbilityBackground.setOnClickListener {
                    eventClickItemPokemonAbility?.onClickItemPokemonAbility(ability)
                }
            }
        }
    }
}
