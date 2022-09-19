package com.example.giupokedex.domain.models.pokeapi_co.detail

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.base.AbilityEffect
import kotlinx.parcelize.Parcelize

@Parcelize
data class AbilityDetail(
    var id: Int = 0,
    var name: String = "",
    var effect_entries: List<AbilityEffect> = emptyList(),
) : Parcelable {
    fun getAbilityEffect() = effect_entries[1].effect //[1] is in english
    fun getAbilityShortEffect() = effect_entries[1].short_effect //[1] is in english
}
