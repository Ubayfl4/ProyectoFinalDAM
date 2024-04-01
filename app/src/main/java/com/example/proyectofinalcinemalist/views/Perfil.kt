package com.example.proyectofinalcinemalist.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofinalcinemalist.R

@Preview
@Composable
fun Perfil(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(text = "perfil")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Foto Usuario"
            )
            Text(
                text = "Usuario",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(10.dp)
            )
        }
        Text(
            text = "Favoritas",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        LazyRow(modifier = Modifier.fillMaxSize()) {

        }
        Text(
            text = "Ultimas peliculas vistas",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        LazyRow(modifier = Modifier.fillMaxSize()) {

        }
        Text(
            text = "Ultimas series vistas",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        LazyRow(modifier = Modifier.fillMaxSize()) {
            //items()
        }
    }
}