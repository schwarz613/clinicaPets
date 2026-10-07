package com.clinicapets

import com.clinicapets.model.Servico
import com.clinicapets.service.ClinicService
import java.util.Locale

fun main() {
    println("=========================================")
    println("      ClinicaPets Management System      ")
    println("=========================================")

    val clinic = ClinicService()
    val servicos = clinic.servicosDisponiveis

    println("\n--- Cadastro Inicial do Pet ---")
    val pet = clinic.registrarPet()

    var opcao: Int

    do {
        println("\nEscolha uma opção:")
        println("1. Listar serviços")
        println("2. Solicitar serviço")
        println("3. Sair")
        print("Opção: ")

        opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> {
                println("\n--- Serviços disponíveis ---")
                for (servico in servicos) {
                    println("${servico.descricao} - R$ ${String.format(Locale.US, "%.2f", servico.preco)}")
                }
            }

            2 -> {
                val servicosSelecionados = mutableListOf<Servico>()
                var escolhaServico: Int?

                println("\n--- Solicitar Serviços para ${pet.nome} ---")

                do {
                    println("\nEscolha um serviço para adicionar (ou 0 para finalizar):")
                    for ((index, servico) in servicos.withIndex()) {
                        println("${index + 1}. ${servico.descricao} - R$ ${String.format(Locale.US, "%.2f", servico.preco)}")
                    }
                    println("0. Finalizar seleção e registrar atendimento")
                    print("Escolha: ")

                    escolhaServico = readLine()?.toIntOrNull()

                    when {
                        escolhaServico == 0 -> {
                            println("Finalizando seleção de serviços...")
                        }
                        escolhaServico != null && escolhaServico in 1..servicos.size -> {
                            val servicoEscolhido = servicos[escolhaServico - 1]
                            servicosSelecionados.add(servicoEscolhido)
                            println("-> Serviço adicionado: ${servicoEscolhido.descricao} (R$ ${String.format(Locale.US, "%.2f", servicoEscolhido.preco)})")
                            println("Total de serviços selecionados até agora: ${servicosSelecionados.size}")
                        }
                        else -> {
                            println("-> Opção inválida. Digite o número correspondente ao serviço ou 0 para finalizar.")
                        }
                    }
                } while (escolhaServico != 0)

                if (servicosSelecionados.isEmpty()) {
                    println("\nNenhum serviço foi selecionado. Atendimento não registrado.")
                } else {
                    // Registra o atendimento no ClinicService
                    val atendimento = clinic.registrarAtendimento(pet, servicosSelecionados)

                    // Mostra o resumo completo do pagamento
                    println("\n=========================================")
                    println("        RESUMO DO ATENDIMENTO")
                    println("=========================================")
                    println("Pet: ${atendimento.pet.nome} (${atendimento.pet.especie})")
                    println("Peso: ${atendimento.pet.peso} kg | Agressivo: ${if (atendimento.pet.agressivo) "Sim" else "Não"}")
                    println("Alergia: ${atendimento.pet.alergia}")
                    println("Status: ${atendimento.descricaoStatus()}")
                    println("-----------------------------------------")
                    println("Serviços Contratados:")
                    for (s in atendimento.servicos) {
                        println("  - ${s.descricao.padEnd(25)} R$ ${String.format(Locale.US, "%.2f", s.preco)}")
                    }
                    println("-----------------------------------------")
                    println("Subtotal dos serviços:    R$ ${String.format(Locale.US, "%.2f", atendimento.subtotal())}")
                    println("Taxa adicional fixa:      R$ ${String.format(Locale.US, "%.2f", atendimento.taxaAdicional)}")
                    println("-----------------------------------------")
                    println("TOTAL A PAGAR:            R$ ${String.format(Locale.US, "%.2f", atendimento.valorTotal())}")
                    println("=========================================")
                }
            }

            3 -> {
                println("Saindo do sistema...")
            }

            else -> {
                println("Opção inválida. Tente novamente.")
            }
        }

    } while (opcao != 3)

    println("\n=========================================")
    println("ClinicaPets finalizado com sucesso!")
    println("=========================================")
}
