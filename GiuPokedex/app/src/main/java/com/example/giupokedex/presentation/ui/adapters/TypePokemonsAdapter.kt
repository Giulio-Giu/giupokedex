package com.example.giupokedex.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.giupokedex.R
import com.example.giupokedex.common.utils.GiuPokedexUtils
import com.example.giupokedex.common.utils.GiuPokedexUtils.getTextInitialCap
import com.example.giupokedex.common.utils.GiuPokedexUtils.show
import com.example.giupokedex.databinding.ItemTypePokemonsBinding
import com.example.giupokedex.domain.models.pokeapi_co.base.TypePokemon

class TypePokemonsAdapter(
    private var type: String,
    private var listTypePokemons: MutableList<TypePokemon>
) : RecyclerView.Adapter<TypePokemonsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemTypePokemonsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listTypePokemons[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return listTypePokemons.size
    }

    inner class ViewHolder(private val viewBinding: ItemTypePokemonsBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bindView(pokemon: TypePokemon) {
            viewBinding.apply {
                itemTypePokemonsName.text = pokemon.name.getTextInitialCap()
                itemTypePokemonsImage.load(pokemon.getImageUrl()) {
                    listener(
                        onSuccess = { _, _ ->
                            itemProgressBarImage.hide()
                            itemTypePokemonsImage.show()
                            itemTypePokemonsImage.scaleType = ImageView.ScaleType.CENTER_INSIDE
                            itemTypePokemonsCardView.setBackgroundColor(
                                GiuPokedexUtils.getTypeColorOrId(
                                    type,
                                    isColor = true
                                )
                            )
                        },
                        onError = { _, _ ->
                            itemProgressBarImage.hide()
                            itemTypePokemonsImage.apply {
                                show()
                                scaleType = ImageView.ScaleType.FIT_CENTER
                                setImageResource(R.drawable.ic_error_outline_24)
                            }
                        }
                    )
                }
            }
        }
    }
}