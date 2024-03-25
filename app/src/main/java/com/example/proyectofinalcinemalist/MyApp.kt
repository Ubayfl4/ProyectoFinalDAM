package com.example.proyectofinalcinemalist

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import com.example.proyectofinalcinemalist.InfoMenuLateral.*
import com.example.proyectofinalcinemalist.componentes.MenuLateral
import com.example.proyectofinalcinemalist.componentes.TopBarCinemalist

enum class Pantallas{
    Login,
    Register,
    Principal,
    Ficha,
    Listas,
    Perfil
}

@Composable
fun MyApp(){
 val navController = rememberNavController()
 val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    MenuLateral(
        navController = navController,
        drawerState = drawerState
    ){
        Contenido(navController = navController, drawerState = drawerState)
    }

}


@Composable
fun Contenido(
    navController: NavHostController,
    drawerState: DrawerState
){
    var showTopBar by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            if (showTopBar) {
                TopBarCinemalist(drawerState)
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, "Añadir lista")
            }
        }
    ) {
            innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                startDestination = Pantallas.Login.name,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ){
                composable(Pantallas.Login.name){
                    showTopBar = false
                    Login(
                        goToPrincipal = {
                            navController.navigate(Pantallas.Principal.name)
                        },
                        goToRegister = {
                            navController.navigate(Pantallas.Register.name)
                        }
                    )
                }
                composable(Pantallas.Register.name){
                    showTopBar = false
                    Register(
                        goToPrincipal = {
                            navController.navigate(Pantallas.Principal.name)
                        }
                    )
                }
                composable(Pantallas.Principal.name){
                    showTopBar = true
                    Principal(
                        goToFicha = {
                            navController.navigate(Pantallas.Ficha.name)
                        },
                        goToPerfil = {
                            navController.navigate(Pantallas.Perfil.name)
                        },
                        goToListas = {
                            navController.navigate(Pantallas.Listas.name)
                        }
                    )
                }
                composable(Pantallas.Perfil.name){
                    Perfil()
                }
            }
        }
    }
}









@Composable
fun currentRoute(navController: NavHostController): String? =
    navController.currentBackStackEntryAsState().value?.destination?.route





//@Composable
//fun Navegacion(navController: NavHostController, showTopBar: Boolean, ){
//    NavHost(
//        navController = navController,
//        startDestination = Pantallas.Login.name,
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//    ){
//        composable(Pantallas.Login.name){
//            showTopBar = false
//            Login(
//                goToPrincipal = {
//                    navController.navigate(Pantallas.Principal.name)
//                },
//                goToRegister = {
//                    navController.navigate(Pantallas.Register.name)
//                }
//            )
//        }
//        composable(Pantallas.Register.name){
//            showTopBar = false
//            Register(
//                goToPrincipal = {
//                    navController.navigate(Pantallas.Principal.name)
//                }
//            )
//        }
//        composable(Pantallas.Principal.name){
//            showTopBar = true
//            Principal(
//                goToFicha = {
//                    navController.navigate(Pantallas.Ficha.name)
//                },
//                goToPerfil = {
//                    navController.navigate(Pantallas.Perfil.name)
//                },
//                goToListas = {
//                    navController.navigate(Pantallas.Listas.name)
//                }
//            )
//        }
//    }
//}