package com.clinicapets.service

import com.clinicapets.model.Atendimento
import com.clinicapets.model.Pet
import com.clinicapets.model.Servico

class ClinicService {

    val servicosDisponiveis: List<Servico> = listOf(
        Servico("Consulta veterinária", 120.00),
        Servico("Vacinação", 80.00),
        Servico("Banho e tosa", 70.00),
        Servico("Exame de sangue", 90.00),
        Servico("Limpeza dentária", 150.00)
    )

    private val atendimentos = mutableListOf<Atendimento>()

    fun registrarPet(): Pet {
        println("Digite o nome do pet:")
        val nome = readLine().orEmpty()

        println("Digite a espécie:")
        val especie = readLine().orEmpty()

        println("Digite o peso:")
        val peso = readLine()?.toDoubleOrNull() ?: 0.0

        println("O pet é agressivo? (true/false)")
        val agressivo = readLine()?.toBoolean() ?: false

        println("Digite a alergia (ou deixe vazio):")
        val alergiaInput = readLine()

        val alergia = alergiaInput?.ifBlank { null } ?: "Nenhuma alergia conhecida"

        return Pet(
            nome = nome,
            especie = especie,
            peso = peso,
            agressivo = agressivo,
            alergia = alergia
        )
    }

    fun cadastrarPet(
        nome: String,
        especie: String,
        peso: Double,
        agressivo: Boolean,
        alergia: String = "Nenhuma alergia conhecida"
    ): Pet {
        return Pet(
            nome = nome,
            especie = especie,
            peso = peso,
            agressivo = agressivo,
            alergia = alergia
        )
    }

    fun registrarAtendimento(
        pet: Pet,
        servicos: List<Servico>,
        status: Int = 1
    ): Atendimento {
        val atendimento = Atendimento(
            pet = pet,
            servicos = servicos,
            status = status
        )
        atendimentos.add(atendimento)
        return atendimento
    }

    fun listarAtendimentos(): List<Atendimento> = atendimentos.toList()
}
