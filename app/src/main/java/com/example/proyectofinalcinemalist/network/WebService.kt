package com.example.proyectofinalcinemalist.network

import com.example.proyectofinalcinemalist.network.response.PeliculasResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("now_playing")
    suspend fun obtenerCartelera(
        @Query("api_key") apikey: String
    ): Response<PeliculasResponse>

    @GET("popular")
    suspend fun obtenerPopulares(
        @Query("api_key") apikey: String
    ): Response<PeliculasResponse>

    @GET("top_rated")
    suspend fun obtenerTopPuntuacion(
        @Query("api_key") apikey: String
    ): Response<PeliculasResponse>

    @GET("upcoming")
    suspend fun obtenerUpcoming(
        @Query("api_key") apikey: String
    ): Response<PeliculasResponse>
}