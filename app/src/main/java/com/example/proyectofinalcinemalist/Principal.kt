package com.example.proyectofinalcinemalist

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Principal(
    goToFicha: () -> Unit,
    goToPerfil: () -> Unit
){
        Column() {
            Text(text = "principal")
        }
}