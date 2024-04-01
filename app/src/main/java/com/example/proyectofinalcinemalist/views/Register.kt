package com.example.proyectofinalcinemalist.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.proyectofinalcinemalist.R

@Composable
fun Register(goToPrincipal: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.logocinemalist),
            contentDescription = "Logo"
        )
        val usuario = remember { mutableStateOf("") }
        OutlinedTextField(
            value = usuario.value,
            singleLine = true,
            onValueChange = {usuario.value = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Usuario")},
            modifier = Modifier.padding(bottom = 20.dp)
        )
        val email = remember { mutableStateOf("") }
        OutlinedTextField(
            value = email.value,
            singleLine = true,
            onValueChange = {email.value = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text(text = "Email")},
            modifier = Modifier.padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = email.value,
            singleLine = true,
            onValueChange = {email.value = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text(text = "Confirmar Email")},
            modifier = Modifier.padding(bottom = 20.dp)
        )
        val password = remember { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        OutlinedTextField(
            value = password.value,
            singleLine = true,
            onValueChange = {password.value = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            label = { Text(text = "Contraseña") },
            trailingIcon = {
                val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisible) "Hide password" else "Show password"
                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            },
            modifier = Modifier.padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = password.value,
            singleLine = true,
            onValueChange = {password.value = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            label = { Text(text = "Confirmar contraseña") },
            trailingIcon = {
                val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisible) "Hide password" else "Show password"
                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            }
        )
        Button(
            onClick = { goToPrincipal() },
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = "Confirmar")
        }
    }
}