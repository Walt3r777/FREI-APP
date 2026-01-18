package com.example.frei.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TelaLogin(onLoginClick: () -> Unit) {
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

        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Senha") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onLoginClick, modifier = Modifier.fillMaxWidth()) {
            Text("Entrar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaLoginPreview() {
    TelaLogin(onLoginClick = {})
}
