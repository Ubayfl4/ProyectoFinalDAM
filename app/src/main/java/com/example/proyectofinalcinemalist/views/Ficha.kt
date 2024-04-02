package com.example.proyectofinalcinemalist.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.proyectofinalcinemalist.core.Constantes
import com.example.proyectofinalcinemalist.models.PeliculaModel

@Composable
fun Ficha(){
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "nobre pelicula",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Fecha de estreno",
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = "2024-03-27")
                Text(
                    text = "Nota",
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = "7.05")
                Text(
                    text = "Total de votos",
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = "204")

            }
            AsyncImage(model = "", contentDescription = "poster de pelicula")
        }
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
        )
        Text(
            text = "Descripción",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = "A pair of mice attempt to board Noah's Ark: Vini, a charismatic poet with terrible stage fright, and Tito, a talented and charming guitarist. When the rains come, only one male and one female of each species is allowed on Noah's Ark. With the help of an ingenious cockroach and fate's good luck, Vini and Tito sneak their way onto the Ark and together avert a showdown among the ships carnivores and plant eaters. All the while, the animals perform a series of classic songs inspired by world renowned poet, Vinicius de Moraes. Can these talented stowaways use music to break the tension and help these cooped up creatures survive the 40 days and 40 nights together?",
            modifier = Modifier.padding(
                start = 10.dp,
                end = 10.dp,
                bottom = 10.dp
            )
        )
    }
}