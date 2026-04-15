package com.example.polkedex.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun BarraEstatus(modifier: Modifier = Modifier, status: String, statusValue: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.width(45.dp)
        ) {
            Text(
                text = status
            )
        }

        VerticalDivider(
            modifier = Modifier
                .padding(horizontal = 3.dp)
                .height(25.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        )
        Text(
            text = "$statusValue"
        )
        LinearProgressIndicator(
            progress = { 45.toFloat() },
            modifier = Modifier.fillMaxWidth().padding(start = 2.dp),
        )
    }
}