package com.clinicapets.model

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
    val status: Int = 1,
    val taxaAdicional: Double = if (pet.agressivo) 25.00 else 0.00
) {
    fun subtotal(): Double = servicos.sumOf { it.preco }
    fun valorTotal(): Double = subtotal() + taxaAdicional

    fun descricaoStatus(): String {
            return when (status) {
                1 -> "Triagem"
                2 -> "Em Atendimento"
                3 -> "Pronto para Alta"
                else -> "Status Inválido"
            }
        }
}