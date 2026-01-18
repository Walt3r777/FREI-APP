package com.example.frei.ui.busca

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TarefaBusca(
    val titulo: String,
    val descricao: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaBusca(
    onVoltarClick: () -> Unit
) {
    var textoBusca by remember { mutableStateOf("") }

    val listaTarefas = remember {
        listOf(
            TarefaBusca("Estudar Kotlin", "Revisar Jetpack Compose"),
            TarefaBusca("Exercício", "Caminhada de 30 minutos"),
            TarefaBusca("Leitura", "Ler sobre UX Design")
        )
    }

    val resultados = listaTarefas.filter {
        it.titulo.contains(textoBusca, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buscar Tarefas") },
                colors = TopAppBarDefaults.topAppBarColors( // ✅ Substituído
                    containerColor = Color(0xFFF3F4F6)
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            OutlinedTextField(
                value = textoBusca,
                onValueChange = { textoBusca = it },
                label = { Text("Digite para buscar") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(resultados) { tarefa ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = tarefa.titulo,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
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
}


@Preview(showBackground = true)
@Composable
fun TelaBuscaPreview() {
    MaterialTheme {
        TelaBusca(onVoltarClick = {})
    }
}
