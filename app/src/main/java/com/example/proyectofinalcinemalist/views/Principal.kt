package com.example.proyectofinalcinemalist.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Principal(
    goToFicha: () -> Unit,
    goToPerfil: () -> Unit,
    goToListas: () -> Unit
){
        Column() {
            Text(
                text = "Peliculas",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(10.dp)
            )
        }
}