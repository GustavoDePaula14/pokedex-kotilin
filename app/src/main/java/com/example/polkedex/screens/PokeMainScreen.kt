package com.example.polkedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.polkedex.R
import com.example.polkedex.components.CriarPokeCard
import com.example.polkedex.components.CriarPokeImg
import com.example.polkedex.model.Pokemon
import com.example.polkedex.screens.pokemon.PokemonViewModule
import com.example.polkedex.testRespository.getAllPokemon


@Composable
fun TelaInicio(modifier: Modifier = Modifier, navController: NavController) {
    var poke by remember { mutableStateOf(getAllPokemon()) }
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(horizontal = 30.dp, vertical = 10.dp),
        ) {
            Image(
                modifier = Modifier
                    .size(45.dp),
                painter = painterResource(R.drawable.main_icon),
                contentDescription = "",
            )
            Text(
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                text = "Pokédex"
            )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 10.dp),
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = "",
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Gray
                ),
                onValueChange = {},
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",

                        )
                },
                placeholder = {
                    Text(
                        color = Color.Gray,
                        text = "Nome ou ID"
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(poke){poke ->
                    CriarPokeCard(modifier = Modifier, pokemon = poke, navController, pokemonViewModule = PokemonViewModule())
                }
            }
        }
    }
}