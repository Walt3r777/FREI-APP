package com.example.frei.ui.perfil

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaPerfil(
    nomeUsuario: String = "Onecas Benedito",
    emailUsuario: String = "Onecas.Benedito@email.com",
    onLogoutClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil do Usuário") },
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
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = nomeUsuario,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2563EB)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = emailUsuario,
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onLogoutClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
            ) {
                Text("Sair", color = Color.White)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TelaPerfilPreview() {
    MaterialTheme {
        TelaPerfil(onLogoutClick = {})
    }
}
