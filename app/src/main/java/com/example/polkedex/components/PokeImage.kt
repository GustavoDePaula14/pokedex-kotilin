package com.example.polkedex.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage


@Composable
fun CriarPokeImg(modifier: Modifier = Modifier, url: String, size: Int) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .size(size.dp),
        model = url,
        contentDescription = "",

        )
}
