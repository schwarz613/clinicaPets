package com.clinicapets

import com.clinicapets.model.Servico
import com.clinicapets.service.ClinicService
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ClinicServiceTest {

    @Test
    fun testCadastrarPet() {
        val clinic = ClinicService()
        val pet = clinic.cadastrarPet("Thor", "Cachorro", 15.0, false, "Nenhuma")

        assertEquals("Thor", pet.nome)
        assertEquals("Cachorro", pet.especie)
        assertEquals(15.0, pet.peso)
        assertEquals(false, pet.agressivo)
        assertEquals("Nenhuma", pet.alergia)
    }

    @Test
    fun testRegistrarAtendimentoCalculoTotalComAdicional() {
        val clinic = ClinicService()
        val pet = clinic.cadastrarPet("Milo", "Gato", 4.2, true)

        val servicos = listOf(
            Servico("Consulta veterinária", 120.00),
            Servico("Vacinação", 80.00)
        )

        val atendimento = clinic.registrarAtendimento(pet, servicos)

        assertEquals(pet, atendimento.pet)
        assertEquals(2, atendimento.servicos.size)
        assertEquals(1, atendimento.status)
        assertEquals("Triagem", atendimento.descricaoStatus())
        assertEquals(200.00, atendimento.subtotal())
        assertEquals(25.00, atendimento.taxaAdicional)
        assertEquals(225.00, atendimento.valorTotal())

        assertTrue(clinic.listarAtendimentos().contains(atendimento))
    }

    @Test
    fun testStatusDescricaoWhen() {
        val clinic = ClinicService()
        val pet = clinic.cadastrarPet("Thor", "Cachorro", 15.0, false, "Nenhuma")

        val atendimentoTriagem = clinic.registrarAtendimento(pet, emptyList(), 1)
        val atendimentoEmAndamento = clinic.registrarAtendimento(pet, emptyList(), 2)
        val atendimentoPronto = clinic.registrarAtendimento(pet, emptyList(), 3)
        val atendimentoInvalido = clinic.registrarAtendimento(pet, emptyList(), 99)

        assertEquals("Triagem", atendimentoTriagem.descricaoStatus())
        assertEquals("Em Atendimento", atendimentoEmAndamento.descricaoStatus())
        assertEquals("Pronto para Alta", atendimentoPronto.descricaoStatus())
        assertEquals("Status Inválido", atendimentoInvalido.descricaoStatus())
    }
}
