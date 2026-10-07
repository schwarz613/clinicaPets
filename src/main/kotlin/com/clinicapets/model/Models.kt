package com.clinicapets.model

enum class AtendimentoStatus {
    TRIAGEM,
    EM_ANDAMENTO,
    PRONTO_PARA_ALTA
}

data class Pet(
    val nome: String,
    val especie: String,
    val peso: Double,
    val agressivo: Boolean,
    val alergia: String
)

data class Servico(
    val descricao: String,
    val preco: Double
)

data class Atendimento(
    val pet: Pet,
    val servicos: List<Servico>,
    val status: AtendimentoStatus = AtendimentoStatus.TRIAGEM,
    val taxaAdicional: Double = 25.00
) {
    fun subtotal(): Double = servicos.sumOf { it.preco }
    fun valorTotal(): Double = subtotal() + taxaAdicional
}