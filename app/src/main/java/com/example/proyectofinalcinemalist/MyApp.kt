package com.example.proyectofinalcinemalist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


enum class Pantallas(){
    Login,
    Register,
    Principal,
    Ficha,
    Listas,
    Perfil
}
@Composable
fun MyApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold() {
            innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Pantallas.Login.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ){
            composable(Pantallas.Login.name){
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
                Register(
                    goToPrincipal = {
                        navController.navigate(Pantallas.Principal.name)
                    }
                )
            }
            composable(Pantallas.Principal.name){
                Principal(
                    goToFicha = {
                        navController.navigate(Pantallas.Ficha.name)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarCinemalist(){
    CenterAlignedTopAppBar(
        title = { Image(painter = painterResource(id = R.drawable.logocinemalistblanco), contentDescription ="logo" ) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu"
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "busqueda")
            }
        }
    )
}