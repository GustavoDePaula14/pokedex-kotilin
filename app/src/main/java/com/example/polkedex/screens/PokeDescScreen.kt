package com.example.polkedex.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.polkedex.R
import com.example.polkedex.components.BarraEstatus
import com.example.polkedex.components.CriarPokeImg
import com.example.polkedex.model.Pokemon
import com.example.polkedex.screens.pokemon.PokemonViewModule

@Composable
fun PokemonDescScreen(modifier: Modifier, navController: NavController, pokemonViewModule: PokemonViewModule){

    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.Gray)){
        Image(
            modifier = Modifier
                .size(220.dp)
                .padding(15.dp)
                .align(alignment = Alignment.TopEnd),
            painter = painterResource(R.drawable.main_icon),
            contentDescription = ""
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        modifier = Modifier,
                        tint = Color.White,
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = ""
                    )
                }
                Text(
                    color = Color.White,
                    text = "${pokemonViewModule.name.value}"
                )
            }
            Text(
                modifier = Modifier.padding(15.dp),
                color = Color.White,
                text = "${pokemonViewModule.id.value}"
            )
        }
        Card(
            Modifier
                .fillMaxWidth()
                .height(450.dp)
                .align(Alignment.BottomCenter)
                .background(Color.White)
                .padding(horizontal = 5.dp),
        ) {
            Spacer(Modifier.height(45.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,


                ) {
                Column() {
                    Text(
                        text = "${pokemonViewModule.id.value}"
                    )
                }
                Spacer(Modifier.width(50.dp))
                Column() {
                    Text(
                        text = "Tipo 2"
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "ABOUT"
            )
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Column() {
                    Row() {
                        Image(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(R.drawable.main_icon),
                            contentDescription = ""
                        )
                        Text(
                            text = "6,9kg"
                        )
                    }
                    Text(
                        text = "Weight"
                    )
                }
                VerticalDivider(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .height(80.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                Column() {
                    Row() {
                        Image(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(R.drawable.main_icon),
                            contentDescription = ""
                        )
                        Text(
                            text = "70m"
                        )
                    }
                    Text(
                        text = "Height"
                    )
                }
                VerticalDivider(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .height(80.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                Column() {
                    Text(
                        text = "Abilidade 1"
                    )
                    Text(
                        text = "Ablidade 2"
                    )
                    Text(
                        text = "Ablidades"
                    )
                }
            }
            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp),
                text = "Quand il est jeune, il absorbe les nutrimentsr"
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Base Stats"
            )

            Column(Modifier.padding(horizontal = 15.dp)) {
                BarraEstatus(status = "HP", statusValue = 11.toFloat())
                BarraEstatus(status = "ATK", statusValue = 11.toFloat())
                BarraEstatus(status = "DEF", statusValue = 11.toFloat())
                BarraEstatus(status = "SATK", statusValue = 11.toFloat())
                BarraEstatus(status = "SDEF", statusValue = 11.toFloat())
                BarraEstatus(status = "SPD", statusValue = 11.toFloat())
            }
        }
    }
    Column() {
        Button(
            onClick = {
                Log.d("TAG", "${pokemonViewModule.image.value}")
            }
        ) { }
        Spacer(Modifier.height(70.dp))
        CriarPokeImg(
            modifier = Modifier,
            url = pokemonViewModule.image.toString(),
            size = 200
        )
    }
}