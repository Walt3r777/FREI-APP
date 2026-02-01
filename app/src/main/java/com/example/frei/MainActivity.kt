package com.example.frei

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.example.frei.model.Tarefa
import com.example.frei.model.Usuario
import com.example.frei.navigation.AppNavHost
import com.example.frei.ui.theme.FREITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FREITheme {

                val navController = rememberNavController()

                var usuarioLogado by remember {
                    mutableStateOf<Usuario?>(null)
                }

                val listaTarefas = remember {
                    mutableStateListOf<Tarefa>()
                }

                AppNavHost(
                    navController = navController,
                    usuarioLogado = usuarioLogado,
                    onLogin = { usuarioLogado = it },
                    onLogout = { usuarioLogado = null },
                    listaTarefas = listaTarefas
                )
            }
        }
    }
}

