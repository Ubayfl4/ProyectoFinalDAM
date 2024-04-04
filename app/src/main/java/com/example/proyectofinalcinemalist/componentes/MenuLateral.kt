package com.example.proyectofinalcinemalist.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyectofinalcinemalist.Contenido
import com.example.proyectofinalcinemalist.currentRoute
import com.example.proyectofinalcinemalist.viewmodels.PeliculasViewModel
import kotlinx.coroutines.launch

@Composable
fun MenuLateral(
    navController: NavHostController,
    drawerState: DrawerState,
    contenido: @Composable () -> Unit,
){
    val botones = listOf(
        InfoMenuLateral.InfoMenuLateral1,
        InfoMenuLateral.InfoMenuLateral2,
        InfoMenuLateral.InfoMenuLateral3,
        InfoMenuLateral.InfoMenuLateral4
    )
    val scope = rememberCoroutineScope()
    val botonSeleccionado = remember { mutableStateOf(botones[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                botones.forEach{ boton ->
                    NavigationDrawerItem(
                        label = { Text(text = boton.nombre) },
                        selected = currentRoute(navController) == boton.ruta,
                        modifier = Modifier.padding(10.dp),
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(boton.ruta)
                        }
                    )
                }
            }
        }
    ) {
        Contenido(navController, drawerState, viewModel = PeliculasViewModel())
    }
}