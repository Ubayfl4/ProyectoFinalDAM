package com.example.proyectofinalcinemalist.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.proyectofinalcinemalist.core.Constantes
import com.example.proyectofinalcinemalist.models.PeliculaModel

@Composable
fun CardPelicula(
    onClick: () -> Unit,
    pelicula: PeliculaModel,
){
    Column {
        Card(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(8.dp)
                .clickable { onClick() }
        ) {
            Row {
                Column {
                    InicioImagen(imagen = pelicula.poster)
                }
//                Column(modifier = Modifier.padding(10.dp)) {
//                    Text(
//                        text = pelicula.nombrePelicula,
//                        fontWeight = FontWeight.ExtraBold
//                    )
//                    Text(text = pelicula.fechaLanzamiento)
//                    Text(text = "Nota: ${pelicula.votoPromedio}")
//                    Text(text = "Nº votos: ${pelicula.totalVotos}")
//                }
            }
        }
    }
}

@Composable
fun InicioImagen(imagen: String) {
    AsyncImage(
        modifier = Modifier.fillMaxWidth(),
        model = Constantes.BASE_URL_IMAGEN + imagen,
        contentDescription = "imagen",
        contentScale = ContentScale.Crop
    )
}