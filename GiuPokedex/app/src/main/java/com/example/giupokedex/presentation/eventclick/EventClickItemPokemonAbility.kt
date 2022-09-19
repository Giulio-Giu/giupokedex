package com.example.giupokedex.presentation.eventclick

import com.example.giupokedex.domain.models.pokeapi_co.base.Ability

interface EventClickItemPokemonAbility {
    fun onClickItemPokemonAbility(ability: Ability)
}