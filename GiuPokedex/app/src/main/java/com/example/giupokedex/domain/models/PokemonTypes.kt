package com.example.giupokedex.domain.models

import android.os.Parcelable
import com.example.giupokedex.domain.models.base.TypeDetail
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonTypes(
    var type: TypeDetail = TypeDetail(),
) : Parcelable
