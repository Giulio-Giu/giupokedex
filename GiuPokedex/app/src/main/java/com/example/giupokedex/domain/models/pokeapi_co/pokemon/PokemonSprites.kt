package com.example.giupokedex.domain.models.pokeapi_co.pokemon

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.PokemonGenerations
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonSprites(
    var back_default: String = "",
    var back_female: String = "",
    var back_shiny: String = "",
    var back_shiny_female: String = "",
    var front_default: String = "",
    var front_female: String = "",
    var front_shiny: String = "",
    var front_shiny_female: String = "",

    var generations: PokemonGenerations = PokemonGenerations(),
) : Parcelable {

    fun getImagesArrayList(): ArrayList<String> {
        val arrayImages = arrayListOf<String>()

        if (front_default.isNotEmpty()) arrayImages.add(front_default)
        if (back_default.isNotEmpty()) arrayImages.add(back_default)
        if (front_female.isNotEmpty()) arrayImages.add(front_female)
        if (back_female.isNotEmpty()) arrayImages.add(back_female)
        if (front_shiny.isNotEmpty()) arrayImages.add(front_shiny)
        if (back_shiny.isNotEmpty()) arrayImages.add(back_shiny)
        if (front_shiny_female.isNotEmpty()) arrayImages.add(front_shiny_female)
        if (back_shiny_female.isNotEmpty()) arrayImages.add(back_shiny_female)

        return arrayImages
    }
}