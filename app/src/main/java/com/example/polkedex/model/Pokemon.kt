package com.example.polkedex.model

import android.media.Image

data class Pokemon(
    val id: String,
    val name: String,
    val image: String,
    val description: String,
    val height: Int,
    val weight: Int,
    val abilities: List<Abilities>,
    val stats: List<Stats>,
    val types: List<Types>
)