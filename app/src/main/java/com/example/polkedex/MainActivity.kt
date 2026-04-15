package com.example.polkedex


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.polkedex.screens.PokemonDescScreen

import com.example.polkedex.screens.TelaInicio
import com.example.polkedex.screens.pokemon.PokemonViewModule
import com.example.polkedex.ui.theme.PolkedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PolkedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "inicioPokedex"
                    ){
                        composable(
                            route = "inicioPokedex"
                        ){
                            TelaInicio(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(
                            route = "descPoke"
                        ){
                            PokemonDescScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                pokemonViewModule = PokemonViewModule()
                            )
                        }
                    }
                }
            }
        }
    }
}
