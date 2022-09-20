package com.example.giupokedex.domain.models.pokeapi_co.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//info do habilidade que tem na lista de habilidades do pokemon
@Parcelize
data class Ability(
    var name: String = "",
    var url: String = ""
) : Parcelable {

    fun getAbilityId(): String = url.split("/".toRegex()).dropLast(1).last()
}