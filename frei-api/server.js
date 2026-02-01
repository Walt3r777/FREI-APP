const express = require("express");
const cors = require("cors");

const app = express();
const PORT = 3000;

// Middleware
app.use(cors());
app.use(express.json());

// "Banco de dados" em memória
let usuarios = [];
let idCounter = 1;

// Rota de criação de conta
app.post("/usuarios", (req, res) => {
    const { nome, email, senha } = req.body;

    // Validação básica
    if (!nome || !email || !senha) {
        return res.status(400).json({ erro: "Nome, email e senha são obrigatórios." });
    }

    // Verifica se email já existe
    const existe = usuarios.find(u => u.email === email);
    if (existe) {
        return res.status(400).json({ erro: "Email já cadastrado." });
    }

    const novoUsuario = {
        id: idCounter++,
        nome,
        email,
        senha // em produção não se salva senha em texto puro!
    };

    usuarios.push(novoUsuario);
    res.status(201).json({ id: novoUsuario.id, nome: novoUsuario.nome, email: novoUsuario.email });
});

// Inicia o servidor
app.listen(PORT, () => {
    console.log(`Servidor rodando em http://localhost:${PORT}`);
});
