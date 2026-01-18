package com.example.frei.ui.tarefa

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastroTarefa(
    onSalvarClick: () -> Unit,
    onCancelarClick: () -> Unit
) {
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Nova Tarefa",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF3F4F6)
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
        ) {

            Text(
                text = "Cadastrar nova tarefa",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2563EB)
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text("Título da tarefa") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = descricao,
                onValueChange = { descricao = it },
                label = { Text("Descrição") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(onClick = onCancelarClick) {
                    Text("Cancelar")
                }

                Button(onClick = onSalvarClick) {
                    Text("Salvar")
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TelaCadastroTarefaPreview() {
    MaterialTheme {
        TelaCadastroTarefa(
            onSalvarClick = {},
            onCancelarClick = {}
        )
    }
}
