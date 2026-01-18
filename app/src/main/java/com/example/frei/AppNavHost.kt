package com.example.frei


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.frei.ui.busca.TelaBusca
import com.example.frei.ui.login.TelaLogin
import com.example.frei.ui.perfil.TelaPerfil
import com.example.frei.ui.principal.TelaPrincipal
import com.example.frei.ui.splash.TelaSplash

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash",
        modifier = modifier
    ) {

        composable("splash") {
            TelaSplash {
                navController.navigate("login") {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }

        composable("login") {
            TelaLogin(
                onLoginClick = {
                    navController.navigate("principal")
                }
            )
        }

        composable("principal") {
            TelaPrincipal(
                onAddTarefaClick = {
                    navController.navigate("nova_tarefa")
                },
                onPerfilClick = {
                    navController.navigate("perfil")
                },
                onBuscaClick = {
                    navController.navigate("buscar")
                }
            )
        }

        composable("nova_tarefa") {
            TelaTarefa(
                onSalvarClick = {
                    navController.popBackStack()
                },
                onCancelarClick = {
                    navController.popBackStack()
                }
            )
        }

        composable("perfil") {
            TelaPerfil(
                onLogoutClick = {
                    navController.navigate("login") {
                        popUpTo("principal") { inclusive = true }
                    }
                }
            )
        }

        composable("buscar") {
            TelaBusca(
                onVoltarClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
