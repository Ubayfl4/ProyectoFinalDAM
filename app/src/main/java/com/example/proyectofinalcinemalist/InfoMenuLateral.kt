package com.example.proyectofinalcinemalist

import androidx.navigation.NavController
import androidx.navigation.NavHostController

sealed class InfoMenuLateral(val nombre: String, val ruta: String){
    object InfoMenuLateral1: InfoMenuLateral(
        nombre = "Perfil",
        ruta = Pantallas.Perfil.name
    )
    object InfoMenuLateral2: InfoMenuLateral(
        nombre = "Inicio",
        ruta = Pantallas.Principal.name
    )
    object InfoMenuLateral3: InfoMenuLateral(
        nombre = "Listas",
        ruta = Pantallas.Listas.name
    )
    object InfoMenuLateral4: InfoMenuLateral(
        nombre = "Cerrar seción",
        ruta = Pantallas.Login.name
    )
}
