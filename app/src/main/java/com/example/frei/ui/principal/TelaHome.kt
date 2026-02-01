package com.example.frei.ui.principal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Tarefa(val titulo: String, val descricao: String)

@Composable
fun TelaHome(
    listaTarefas: List<Tarefa>,
    onAddTarefaClick: () -> Unit,
    onPerfilClick: () -> Unit,
    onBuscaClick: () -> Unit
) {
    Scaffold(
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
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = tarefa.titulo,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
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
