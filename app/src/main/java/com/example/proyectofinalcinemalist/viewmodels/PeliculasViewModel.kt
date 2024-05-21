package com.example.proyectofinalcinemalist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinalcinemalist.core.Constantes
import com.example.proyectofinalcinemalist.models.PeliculaModel
import com.example.proyectofinalcinemalist.network.RetrofitClient
//import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//class PeliculasViewModel: ViewModel() {
//
//    private var _listaPeliculas = MutableStateFlow<List<PeliculaModel>>(emptyList())
//    val listaPeliculas = _listaPeliculas.asStateFlow()
//
//
//    fun obtenerPeliculaPorId(peliculaId: Int): PeliculaModel? {
//        // Busca la película en la lista de películas basándote en el ID
//        return _listaPeliculas.value.find { it.id == peliculaId.toString().toString() }
//    }
//
//    init {
//        obtenerCartelera()
//        obtenerUpcoming()
//        obtenerPopulares()
//        obtenerTopPuntuacion()
//    }
//
//
//
//    fun obtenerCartelera(){
//        viewModelScope.launch(Dispatchers.IO){
//            val response = RetrofitClient.webService.obtenerCartelera(Constantes.API_KEY)
//            withContext(Dispatchers.Main){
//                _listaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.votoPromedio }
//            }
//        }
//    }
//
//    fun obtenerPopulares(){
//        viewModelScope.launch(Dispatchers.IO){
//            val response = RetrofitClient.webService.obtenerPopulares(Constantes.API_KEY)
//            withContext(Dispatchers.Main){
//                _listaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.totalVotos }
//            }
//        }
//    }
//
//    fun obtenerTopPuntuacion(){
//        viewModelScope.launch(Dispatchers.IO){
//            val response = RetrofitClient.webService.obtenerTopPuntuacion(Constantes.API_KEY)
//            withContext(Dispatchers.Main){
//                _listaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.votoPromedio }
//            }
//        }
//    }
//
//    fun obtenerUpcoming(){
//        viewModelScope.launch(Dispatchers.IO){
//            val response = RetrofitClient.webService.obtenerUpcoming(Constantes.API_KEY)
//            withContext(Dispatchers.Main){
//                _listaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.fechaLanzamiento }
//            }
//        }
//    }
//}

class PeliculasViewModel: ViewModel() {

    private var _listaPeliculasCartelera = MutableStateFlow<List<PeliculaModel>>(emptyList())
    val listaPeliculasCartelera = _listaPeliculasCartelera.asStateFlow()

    private var _listaPeliculasPopulares = MutableStateFlow<List<PeliculaModel>>(emptyList())
    val listaPeliculasPopulares = _listaPeliculasPopulares.asStateFlow()

    private var _listaPeliculasTopPuntuacion = MutableStateFlow<List<PeliculaModel>>(emptyList())
    val listaPeliculasTopPuntuacion = _listaPeliculasTopPuntuacion.asStateFlow()

    private var _listaPeliculasUpcoming = MutableStateFlow<List<PeliculaModel>>(emptyList())
    val listaPeliculasUpcoming = _listaPeliculasUpcoming.asStateFlow()

    private var _listaPeliculas = MutableStateFlow<List<PeliculaModel>>(emptyList())
    val listaPeliculas = _listaPeliculas.asStateFlow()

    fun obtenerPeliculaPorId(peliculaId: Int): PeliculaModel? {
        // Busca la película en la lista de películas basándote en el ID
        return _listaPeliculasCartelera.value.find { it.id == peliculaId.toString() } ?:
        _listaPeliculasPopulares.value.find { it.id == peliculaId.toString() } ?:
        _listaPeliculasTopPuntuacion.value.find { it.id == peliculaId.toString() } ?:
        _listaPeliculasUpcoming.value.find { it.id == peliculaId.toString() }
    }

    init {
        obtenerCartelera()
        obtenerUpcoming()
        obtenerPopulares()
        obtenerTopPuntuacion()
    }

    private fun combinarListas() {
        _listaPeliculas.value = _listaPeliculasCartelera.value +
                _listaPeliculasPopulares.value +
                _listaPeliculasTopPuntuacion.value +
                _listaPeliculasUpcoming.value
    }

    fun obtenerCartelera(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.obtenerCartelera(Constantes.API_KEY)
            withContext(Dispatchers.Main){
                _listaPeliculasCartelera.value = response.body()!!.resultados.sortedByDescending { it.votoPromedio }
                combinarListas()
            }
        }
    }

    fun obtenerPopulares(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.obtenerPopulares(Constantes.API_KEY)
            withContext(Dispatchers.Main){
                _listaPeliculasPopulares.value = response.body()!!.resultados.sortedByDescending { it.totalVotos }
                combinarListas()
            }
        }
    }

    fun obtenerTopPuntuacion(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.obtenerTopPuntuacion(Constantes.API_KEY)
            withContext(Dispatchers.Main){
                _listaPeliculasTopPuntuacion.value = response.body()!!.resultados.sortedByDescending { it.votoPromedio }
                combinarListas()
            }
        }
    }

    fun obtenerUpcoming(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.obtenerUpcoming(Constantes.API_KEY)
            withContext(Dispatchers.Main){
                _listaPeliculasUpcoming.value = response.body()!!.resultados.sortedByDescending { it.fechaLanzamiento }
                combinarListas()
            }
        }
    }
}