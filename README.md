# clinicaPets - Estudo de Caso 6: Clínica Veterinária

## 📋 Contextualização

Vocês foram contratados para desenvolver o sistema de controle de atendimento de uma clínica veterinária. O sistema deve gerenciar serviços prestados, calcular taxas com base no comportamento do pet e tratar informações opcionais sobre alergias.

---

## 📌 Requisitos Obrigatórios

- **POO:** Classes e objetos (`Pet`, `Servico`, `Atendimento`).
- **Variáveis e Tipos:** `String`, `Double`, `Boolean`.
- **Condicionais:** `if/else` e `when`.
- **Laços:** `for` para iterar sobre os serviços realizados.
- **Null Safety:** Alergias e observações opcionais.

---

## ⚙️ Regras de Negócio

1. **Modelagem:** `Pet` (nome, especie, peso), `Servico` (descricao, preco), `Atendimento`.
2. **Carrinho de Serviços:** Iterar sobre a lista de serviços executados para calcular o subtotal.
3. **Taxa de Agressividade (`if/else`):** Se o pet possuir o indicador de comportamento agressivo (`true`), adicionar uma taxa adicional de manuseio de R$ 25,00.
4. **Alergias (Null Safety):** O campo `alergias` é opcional (Nullable). Utilizar chamada segura e operador Elvis para registrar "Nenhuma alergia conhecida" caso o campo seja nulo.
5. **Status do Atendimento (`when`):** Avaliar o código de status:
   - `1` -> "Triagem"
   - `2` -> "Em Atendimento"
   - `3` -> "Pronto para Alta"  
   e emitir a mensagem correspondente.

---

Aluno: Paulo Barbosa de Almeida Junior
