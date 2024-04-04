package com.example.proyectofinalcinemalist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinalcinemalist.core.Constantes
import com.example.proyectofinalcinemalist.models.PeliculaModel
import com.example.proyectofinalcinemalist.network.RetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PeliculasViewModel: ViewModel() {

    private var _listaPeliculas = MutableStateFlow<List<PeliculaModel>>(emptyList())
    val listaPeliculas = _listaPeliculas.asStateFlow()


    fun obtenerPeliculaPorId(peliculaId: Int): PeliculaModel? {
        // Busca la película en la lista de películas basándote en el ID
        return _listaPeliculas.value.find { it.id == peliculaId.toString() }
    }

    init {
        obtenerCartelera()
    }

    init {
        obtenerPopulares()
    }

    init {
        obtenerTopPuntuacion()
    }

    init {
        obtenerUpcoming()
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

    fun obtenerTopPuntuacion(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.obtenerTopPuntuacion(Constantes.API_KEY)
            withContext(Dispatchers.Main){
                _listaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.votoPromedio }
            }
        }
    }

    fun obtenerUpcoming(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.obtenerUpcoming(Constantes.API_KEY)
            withContext(Dispatchers.Main){
                _listaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.votoPromedio }
            }
        }
    }
}