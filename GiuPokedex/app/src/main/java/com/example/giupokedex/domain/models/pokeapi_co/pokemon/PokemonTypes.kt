package com.example.giupokedex.domain.models.pokeapi_co.pokemon

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.Type
import kotlinx.parcelize.Parcelize

//lista de tipos que um pokemon tem
@Parcelize
data class PokemonTypes(
    var type: Type = Type(),
) : Parcelable
