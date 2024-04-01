package com.example.proyectofinalcinemalist.network.response

import com.example.proyectofinalcinemalist.models.PeliculaModel
import com.google.gson.annotations.SerializedName

data class PeliculasResponse(
    @SerializedName("results")
    var resultados: List<PeliculaModel>
)
