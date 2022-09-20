package com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base

import android.os.Parcelable
import com.example.giupokedex.data.datasource.remote.modelresponse.pokeapi_co.base.generations.*
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonGenerationsResponse(
    var `generation-i`: Generation1Response? = null,
    var `generation-ii`: Generation2Response? = null,
    var `generation-iii`: Generation3Response? = null,
    var `generation-iv`: Generation4Response? = null,
    var `generation-v`: Generation5Response? = null,
    var `generation-vi`: Generation6Response? = null,
    var `generation-vii`: Generation7Response? = null,
    var `generation-viii`: Generation8Response? = null,
) : Parcelable