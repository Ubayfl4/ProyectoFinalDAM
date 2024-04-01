package com.example.proyectofinalcinemalist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinalcinemalist.core.Constantes
import com.example.proyectofinalcinemalist.models.PeliculaModel
import com.example.proyectofinalcinemalist.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PeliculasViewModel: ViewModel() {

    private var _listaPeliculas = MutableLiveData<List<PeliculaModel>>()
    val listaPeliculas: LiveData<List<PeliculaModel>> = _listaPeliculas

    init {
        obtenerCartelera()
    }

    init {
        obtenerPopulares()
    }
    fun obtenerCartelera(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.obtenerCartelera(Constantes.API_KEY)
            withContext(Dispatchers.Main){
                _listaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.votoPromedio }
            }
        }
    }

    fun obtenerPopulares(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.obtenerPopulares(Constantes.API_KEY)
            withContext(Dispatchers.Main){
                _listaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.votoPromedio }
            }
        }
    }
}