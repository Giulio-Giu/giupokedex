package com.example.giupokedex.common.utils

import android.app.Activity
import android.view.View
import android.view.WindowManager
import com.example.giupokedex.R
import com.example.giupokedex.presentation.ui.activities.HomeActivity
import java.util.*

object GiuPokedexUtils {

    lateinit var globalActivity: HomeActivity

    @JvmName("setGlobalActivity1")
    fun setGlobalActivity(activity: HomeActivity) {
        globalActivity = activity
    }

    fun String.getTextInitialCap() = this.replaceFirstChar(Char::titlecase)

    fun enableDisableView(activity: Activity, enabled: Boolean) {
        if (enabled) {
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        } else {
            activity.window.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        }
    }

    fun getRandomColor(): Int {
        val typeList = listOf(
            R.color.flying,
            R.color.poison,
            R.color.ghost,
            R.color.electric,
            R.color.grass,
            R.color.fairy,
            R.color.bug
        )

        return typeList.random()
    }

    fun getTypeColorOrId(type: String, isColor: Boolean): Int {
        return when (type.lowercase(Locale.getDefault())) {
            "fighting" -> if(isColor) R.color.fighting else R.drawable.ic_pokemon_type_fighting
            "flying" -> if(isColor) R.color.flying else R.drawable.ic_pokemon_type_flying
            "poison" -> if(isColor) R.color.poison else R.drawable.ic_pokemon_type_poison
            "ground" -> if(isColor) R.color.ground else R.drawable.ic_pokemon_type_ground
            "rock" -> if(isColor) R.color.rock else R.drawable.ic_pokemon_type_rock
            "bug" -> if(isColor) R.color.bug else R.drawable.ic_pokemon_type_bug
            "ghost" -> if(isColor) R.color.ghost else R.drawable.ic_pokemon_type_ghost
            "steel" -> if(isColor) R.color.steel else R.drawable.ic_pokemon_type_steel
            "fire" -> if(isColor) R.color.fire else R.drawable.ic_pokemon_type_fire
            "water" -> if(isColor) R.color.water else R.drawable.ic_pokemon_type_water
            "grass" -> if(isColor) R.color.grass else R.drawable.ic_pokemon_type_grass
            "electric" -> if(isColor) R.color.electric else R.drawable.ic_pokemon_type_electric
            "psychic" -> if(isColor) R.color.psychic else R.drawable.ic_pokemon_type_psychic
            "ice" -> if(isColor) R.color.ice else R.drawable.ic_pokemon_type_electric
            "dragon" -> if(isColor) R.color.dragon else R.drawable.ic_pokemon_type_dragon
            "fairy" -> if(isColor) R.color.fairy else R.drawable.ic_pokemon_type_fairy
            "dark" -> if(isColor) R.color.dark else R.drawable.ic_pokemon_type_dark
            "normal" -> if(isColor) R.color.normal else R.drawable.ic_pokemon_type_normal
            else -> if(isColor) R.color.undefined else R.drawable.ic_no_found
        }
    }

    fun View.show() {
        this.visibility = View.VISIBLE
    }

    fun View.hide() {
        this.visibility = View.GONE
    }
//
//    fun showKeyboard(view: View) {
//        val inputMethodManager = view.context.getSystemService(
//            Activity.INPUT_METHOD_SERVICE
//        ) as InputMethodManager
//        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
//    }
//
//    fun hideKeyboard(view: View) {
//        val inputMethodManager = view.context.getSystemService(
//            Activity.INPUT_METHOD_SERVICE
//        ) as InputMethodManager
//        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
//    }
}