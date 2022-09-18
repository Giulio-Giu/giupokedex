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

    fun getTypeColor(type: String): Int {
        return when (type.lowercase(Locale.getDefault())) {
            "fighting" -> R.color.fighting
            "flying" -> R.color.flying
            "poison" -> R.color.poison
            "ground" -> R.color.ground
            "rock" -> R.color.rock
            "bug" -> R.color.bug
            "ghost" -> R.color.ghost
            "steel" -> R.color.steel
            "fire" -> R.color.fire
            "water" -> R.color.water
            "grass" -> R.color.grass
            "electric" -> R.color.electric
            "psychic" -> R.color.psychic
            "ice" -> R.color.ice
            "dragon" -> R.color.dragon
            "fairy" -> R.color.fairy
            "dark" -> R.color.dark
            else -> R.color.gray_21
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