package com.example.giupokedex.presentation.eventclick

import com.example.giupokedex.domain.models.pokeapi_co.base.Type

interface EventClickItemPokemonType  {
    fun onClickItemPokemonType(type: Type)
}