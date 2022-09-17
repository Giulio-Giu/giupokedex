package com.example.giupokedex.domain.models

import android.os.Parcelable
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonAbilities
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonSprites
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonStats
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonTypes
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemonFamily
import kotlinx.parcelize.Parcelize

//It will be used to list all pokemon items, since 2 different apis are being used
@Parcelize
data class FullPokemon (
    var number: Int = 0,
    var height: Int = 0,
    var weight: Int = 0,
    var expStat: Int = 0,
    var name: String = "",
    var species: String = "",
    var description: String = "",
    var image: String = "",
    var family: GlitchPokemonFamily = GlitchPokemonFamily(),
    var sprites: PokemonSprites = PokemonSprites(),
    var abilities: List<PokemonAbilities> = emptyList(),
    var stats: List<PokemonStats> = emptyList(),
    var types: List<PokemonTypes> = emptyList(),
    var is_starter: Boolean = false,
    var is_legendary: Boolean = false,
    var is_mythical: Boolean = false,
    var is_ultraBeast: Boolean = false,
    var is_mega: Boolean = false,
): Parcelable