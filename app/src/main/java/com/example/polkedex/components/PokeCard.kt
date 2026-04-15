package com.example.polkedex.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.polkedex.model.Pokemon
import com.example.polkedex.screens.pokemon.PokemonViewModule

@Composable
fun CriarPokeCard(
    modifier: Modifier = Modifier,
    pokemon: Pokemon,
    navController: NavController,
    pokemonViewModule: PokemonViewModule
) {
    Column(
        modifier = Modifier
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(7))
            .clickable(onClick = {
                pokemonViewModule.atulizarDados(pokemon)
                navController.navigate("descPoke")
            }),

        ) {
        Text(
            modifier = Modifier
                .padding(end = 10.dp, top = 3.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.End,
            text = pokemon.id
        )
        CriarPokeImg(modifier = Modifier, url = pokemon.image, size = 60)
        Text(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            text = pokemon.name,
            textAlign = TextAlign.Center,
        )
    }
}