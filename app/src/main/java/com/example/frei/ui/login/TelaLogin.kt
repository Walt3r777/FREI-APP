package com.example.frei.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TelaLogin(
    onLoginClick: (email: String, senha: String) -> Unit,
    onCriarContaClick: () -> Unit  // Novo parâmetro
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("FREI", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2563EB))
        Spacer(modifier = Modifier.height(8.dp))
        Text("Liberdade + Respeito + Igualdade + Empatia", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onLoginClick(email, senha) },
            modifier = Modifier.fillMaxWidth(),
            enabled = email.isNotBlank() && senha.isNotBlank()
        ) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onCriarContaClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Criar Conta")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaLoginPreview() {
    TelaLogin(
        onLoginClick = { _, _ -> },
        onCriarContaClick = { }
    )
}
