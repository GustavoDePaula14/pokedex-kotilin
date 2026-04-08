package com.example.polkedex

import android.R.attr.contentDescription
import android.R.attr.text
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.polkedex.ui.theme.PolkedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PolkedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaInicio(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TelaInicio(modifier: Modifier = Modifier) {
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
                items(39){
                    CriaPokeCard(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun CriaPokeCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(7)),

    ) {
        Text(
            modifier = Modifier
                .padding(end = 10.dp, top = 3.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.End,
            text = "ID"
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(60.dp),
            painter = painterResource(R.drawable.main_icon),
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            text = "Nome",
            textAlign = TextAlign.Center,
        )
    }
}