package com.example.proyectofinalcinemalist.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofinalcinemalist.viewmodels.PeliculasViewModel


@Composable
fun Principal(
    goToFicha: () -> Unit,
    goToPerfil: () -> Unit,
    goToListas: () -> Unit,
    viewModel: PeliculasViewModel
){
    val peliculas by viewModel.listaPeliculas.

        Column() {
            Text(
                text = "Peliculas",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(10.dp)
            )
            LazyRow(modifier = Modifier.fillMaxSize()){

            }
        }
}