package com.example.frei.navigation

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.frei.model.Tarefa
import com.example.frei.ui.busca.TelaBusca
import com.example.frei.ui.login.TelaLogin
import com.example.frei.ui.Criar.TelaCriarConta
import com.example.frei.ui.perfil.TelaPerfil
import com.example.frei.ui.perfil.Usuario
import com.example.frei.ui.principal.TelaHome
import com.example.frei.ui.splash.TelaSplash
import com.example.frei.ui.tarefa.TelaTarefas

object Rotas {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val CRIAR_CONTA = "criar_conta"
    const val HOME = "principal"
    const val TAREFAS = "tarefa"
    const val BUSCA = "busca"
    const val PERFIL = "perfil"
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    usuarioLogado: Usuario?,
    onLogin: (Usuario) -> Unit,
    onLogout: () -> Unit,
    listaTarefas: MutableList<Tarefa>,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = Rotas.SPLASH, modifier = modifier) {

        // Splash Screen
        composable(Rotas.SPLASH) {
            TelaSplash {
                navController.navigate(Rotas.LOGIN) {
                    popUpTo(Rotas.SPLASH) { inclusive = true }
                }
            }
        }

        // Tela de Login
        composable(Rotas.LOGIN) {
            TelaLogin(
                onLoginClick = { email, senha ->
                    val usuario = Usuario(nome = "Usuário Exemplo", email = email)
                    onLogin(usuario)
                    navController.navigate(Rotas.HOME) {
                        popUpTo(Rotas.LOGIN) { inclusive = true }
                    }
                },
                onCriarContaClick = {
                    navController.navigate(Rotas.CRIAR_CONTA)
                }
            )
        }

        // Tela de Criar Conta
        composable(Rotas.CRIAR_CONTA) {
            TelaCriarConta(
                onCadastroClick = { usuario ->
                    onLogin(usuario)
                    navController.navigate(Rotas.HOME) {
                        popUpTo(Rotas.CRIAR_CONTA) { inclusive = true }
                    }
                },
                onVoltarClick = {
                    navController.popBackStack()
                }
            )
        }

        // Tela Home
        composable(Rotas.HOME) {
            TelaHome(
                listaTarefas = listaTarefas,
                onAddTarefaClick = { navController.navigate(Rotas.TAREFAS) },
                onPerfilClick = { navController.navigate(Rotas.PERFIL) },
                onBuscaClick = { navController.navigate(Rotas.BUSCA) }
            )
        }

        // Tela de Cadastro de Tarefa
        composable(Rotas.TAREFAS) {
            TelaTarefas(
                onSalvarClick = { tarefa ->
                    listaTarefas.add(tarefa)
                    navController.popBackStack()
                },
                onCancelarClick = { navController.popBackStack() }
            )
        }

        // Tela de Perfil
        composable(Rotas.PERFIL) {
            if (usuarioLogado != null) {
                TelaPerfil(
                    usuario = usuarioLogado,
                    onLogoutClick = {
                        onLogout()
                        navController.navigate(Rotas.LOGIN) {
                            popUpTo(Rotas.HOME) { inclusive = true }
                        }
                    }
                )
            } else {
                LaunchedEffect(Unit) {
                    navController.navigate(Rotas.LOGIN)
                }
            }
        }

        // Tela de Busca
        composable(Rotas.BUSCA) {
            TelaBusca(
                listaTarefas = listaTarefas,
                onVoltarClick = { navController.popBackStack() }
            )
        }
    }
}
