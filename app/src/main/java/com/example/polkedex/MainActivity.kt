package com.example.polkedex

import android.R.attr.contentDescription
import android.R.attr.tag
import android.R.attr.text
import android.R.attr.thickness
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter.State.Empty.painter
import com.example.polkedex.model.Pokemon
import com.example.polkedex.testRespository.getAllPokemon
import com.example.polkedex.ui.theme.PolkedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PolkedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PokemonDescScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TelaInicio(modifier: Modifier = Modifier) {
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
                    CriarPokeCard(modifier = Modifier, pokemon = poke)
                }
            }
        }
    }
}

@Composable
fun CriarPokeCard(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Column(
        modifier = Modifier
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(7)),

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
@Composable
fun PokemonDescScreen(modifier: Modifier){
    Box(modifier = modifier.fillMaxSize().background(Color.Gray)){
        Row(modifier = Modifier) {
            Row() {
                IconButton(
                    onClick = {}
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
                    text = "Teste 1"
                )
            }
            Text(
                color = Color.White,
                text = "#001"
            )
        }
       Card(
            Modifier
                .fillMaxWidth()
                .height(450.dp)
                .align(Alignment.BottomCenter)
                .background(Color.White),
            ) {
           Spacer(Modifier.height(45.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,


            ){
                Column() {
                    Text(
                        text = "Tipo 1"
                    )
                }
                Spacer(Modifier.width(50.dp))
                Column() {
                    Text(
                        text = "Tipo 2"
                    )
                }
            }
           Text(
               modifier = Modifier.fillMaxWidth(),
               textAlign = TextAlign.Center,
               text = "ABOUT"
           )
           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.Center
           ) {
               Column() {
                   Row() {
                       Image(
                           modifier = Modifier.size(30.dp),
                           painter = painterResource( R.drawable.main_icon),
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
               modifier = Modifier.padding(horizontal = 8.dp).height(80.dp),
               thickness = 1.dp,
               color = MaterialTheme.colorScheme.outlineVariant
           )
               Column() {
                   Row() {
                       Image(
                           modifier = Modifier.size(30.dp),
                           painter = painterResource( R.drawable.main_icon),
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
                   modifier = Modifier.padding(horizontal = 8.dp).height(80.dp),
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
               text = "Quand il est jeune, il absorbe les nutriments\\nconservés dans son dos pour grandir\\net se développer"
           )
           Text(
               modifier = Modifier.fillMaxWidth(),
               textAlign = TextAlign.Center,
               text = "Base Stats"
           )

        }
        Column() {
            Spacer(Modifier.height(45.dp))
            CriarPokeImg(
                modifier = Modifier,
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                size = 200
            )
        }
    }
}

@Composable
fun CriarPokeImg(modifier: Modifier = Modifier, url: String, size: Int) {
    AsyncImage(
        modifier = Modifier.fillMaxWidth().size(size.dp),
        model = url,
        contentDescription = "",

    )
}