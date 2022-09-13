package com.example.giupokedex.data.datasource.remote.modelresponse

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.base.AbilityDetailResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAbilitiesResponse(
    var ability: AbilityDetailResponse? = null,
) : Parcelable
