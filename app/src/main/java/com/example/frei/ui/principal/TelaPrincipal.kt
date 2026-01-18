package com.example.frei.ui.principal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Tarefa(val titulo: String, val descricao: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaPrincipal(
    onAddTarefaClick: () -> Unit,
    onPerfilClick: () -> Unit,
    onBuscaClick: () -> Unit
) {
    val listaTarefas = remember {
        listOf(
            Tarefa("Estudar Kotlin", "Completar exercícios da faculdade"),
            Tarefa("Ler livro", "Ler capítulo sobre UI/UX"),
            Tarefa("Exercício físico", "Fazer 30 minutos de caminhada")
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "FREI",
                        color = Color(0xFF2563EB),
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    TextButton(onClick = onBuscaClick) {
                        Text("Buscar")
                    }
                    TextButton(onClick = onPerfilClick) {
                        Text("Perfil")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF3F4F6)
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddTarefaClick,
                containerColor = Color(0xFF10B981)
            ) {
                Text("+", fontSize = 24.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF3F4F6))
        ) {
            items(listaTarefas) { tarefa ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = tarefa.titulo,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color(0xFF2563EB)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = tarefa.descricao,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TelaPrincipalPreview() {
    MaterialTheme {
        TelaPrincipal(
            onAddTarefaClick = {},
            onPerfilClick = {},
            onBuscaClick = {}
        )
    }
}
