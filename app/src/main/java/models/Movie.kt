package models

import androidx.compose.runtime.Composable

data class Movie(
    val name: String,
    val description: String,
    val actors: List<String>,
    val budget: Int
)




