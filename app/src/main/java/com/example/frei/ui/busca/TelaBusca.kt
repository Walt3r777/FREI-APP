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
import com.example.frei.ui.principal.Tarefa

@Composable
fun TelaBusca(
    listaTarefas: List<Tarefa>, // recebendo lista de tarefas
    onVoltarClick: () -> Unit
) {
    var textoBusca by remember { mutableStateOf("") }

    val resultados = listaTarefas.filter {
        it.titulo.contains(textoBusca, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                    colors = CardDefaults.cardColors(containerColor = Color.White)
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

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onVoltarClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
        ) {
            Text("Voltar", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaBuscaPreview() {
    TelaBusca(
        listaTarefas = listOf(
            Tarefa("Exemplo 1", "Descrição 1"),
            Tarefa("Exemplo 2", "Descrição 2")
        ),
        onVoltarClick = {}
    )
}
