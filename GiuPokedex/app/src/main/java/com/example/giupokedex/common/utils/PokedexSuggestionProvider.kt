package com.example.giupokedex.common.utils

import android.content.SearchRecentSuggestionsProvider

class PokedexSuggestionProvider : SearchRecentSuggestionsProvider() {
    init {
        setupSuggestions(AUTHORITY, MODE)
    }

    companion object {
        const val AUTHORITY = "com.example.PokedexSuggestionProvider"
        const val MODE: Int = DATABASE_MODE_QUERIES
    }
}