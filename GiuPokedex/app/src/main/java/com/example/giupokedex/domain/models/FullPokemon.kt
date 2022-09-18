package com.example.giupokedex.domain.models

import android.os.Parcelable
import com.example.giupokedex.R
import com.example.giupokedex.common.utils.GiuPokedexUtils
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonAbilities
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonSprites
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonStats
import com.example.giupokedex.domain.models.pokeapi_co.pokemon.PokemonTypes
import com.example.giupokedex.domain.models.pokeapi_glitch.GlitchPokemonFamily
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

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
    val hp: Int = Random.nextInt(maxHp),
    val attack: Int = Random.nextInt(maxAttack),
    val defense: Int = Random.nextInt(maxDefense),
    val special_attack: Int = Random.nextInt(maxSpecialAttack),
    val special_defense: Int = Random.nextInt(maxSpecialDefense),
    val speed: Int = Random.nextInt(maxSpeed),
    val exp: Int = Random.nextInt(maxExp)
): Parcelable {

    fun getNumberString(): String = "Nº ${number.toString().padStart(3, '0')}"
    fun getHeightString(): String = String.format("%.1f m", height.toFloat() / 10)
    fun getWeightString(): String = String.format("%.1f kg", weight.toFloat() / 10)

    fun getHpString(): String = "$hp/$maxHp"
    fun getAttackString(): String = "$attack/$maxAttack"
    fun getDefenseString(): String = "$defense/$maxDefense"
    fun getSpecialAttackString(): String = "$special_attack/$maxSpecialAttack"
    fun getSpecialDefenseString(): String = "$special_defense/$maxSpecialDefense"
    fun getSpeedString(): String = "$speed/$maxSpeed"
    fun getExpString(): String = "$exp/$maxExp"

    companion object {
        val maxHp = GiuPokedexUtils.globalActivity.resources.getInteger(R.integer.stats_max_hp)
        val maxAttack = GiuPokedexUtils.globalActivity.resources.getInteger(R.integer.stats_max_attack)
        val maxDefense = GiuPokedexUtils.globalActivity.resources.getInteger(R.integer.stats_max_defense)
        val maxSpecialAttack = GiuPokedexUtils.globalActivity.resources.getInteger(R.integer.stats_max_special_attack)
        val maxSpecialDefense = GiuPokedexUtils.globalActivity.resources.getInteger(R.integer.stats_max_special_defense)
        val maxSpeed = GiuPokedexUtils.globalActivity.resources.getInteger(R.integer.stats_max_speed)
        val maxExp = GiuPokedexUtils.globalActivity.resources.getInteger(R.integer.stats_max_exp)
    }
}