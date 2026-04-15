package com.example.polkedex.testRespository

import androidx.compose.foundation.Image
import com.example.polkedex.model.Abilities
import com.example.polkedex.model.Pokemon
import com.example.polkedex.model.Stats
import com.example.polkedex.model.Types

fun getAllPokemon(): List<Pokemon>{
    return listOf(
        Pokemon(
            id = "001",
            name = "Teste 666",
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            height = 70,
            weight = 69,
            abilities = listOf(
                Abilities(ability = "Teste 1"),
                Abilities(ability = "Teste 2")
            ),
            stats = listOf(
                Stats(base_stat = 10),
                Stats(base_stat = 50),
                Stats(base_stat = 90),
                Stats(base_stat = 100),
                Stats(base_stat = 31),
            ),
            types = listOf(
                Types(type = "fire"),
                Types(type = "ice")
            ),
            description = ""
        ),
        Pokemon(
            id = "0545401",
            name = "Teste 6",
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/454.png",
            height = 70,
            weight = 69,
            abilities = listOf(
                Abilities(ability = "Teste 1"),
                Abilities(ability = "Teste 2")
            ),
            stats = listOf(
                Stats(base_stat = 30),
                Stats(base_stat = 30),
                Stats(base_stat = 30),
                Stats(base_stat = 30),
                Stats(base_stat = 30),
            ),
            types = listOf(
                Types(type = "fire"),
                Types(type = "ice")
            ),
            description = ""
        )
    )
}