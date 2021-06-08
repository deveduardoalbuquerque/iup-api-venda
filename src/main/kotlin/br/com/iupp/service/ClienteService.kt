package br.com.iupp.service

import br.com.iupp.controller.dto.ClienteRequest
import br.com.iupp.controller.dto.ClienteResponse
import br.com.iupp.controller.dto.EnderecoRequest
import br.com.iupp.model.Cliente
import br.com.iupp.repositoy.ClienteRepository
import br.com.iupp.repositoy.EnderecoRepository
import br.com.iupp.util.externo.BuscaEndereco
import java.lang.RuntimeException
import javax.inject.Singleton

@Singleton
class ClienteService(val repository: ClienteRepository,
                     val enderecoRepository: EnderecoRepository,
                     val buscaEndereco: BuscaEndereco) {

    fun salvaCliente(clienteRequest: ClienteRequest, cep:String): ClienteResponse {

        val enderecoRequest: EnderecoRequest = buscaEndereco.buscaEndereceoPorCEP(cep = cep)
        if(enderecoRequest != null){
            val enderecoSaldo = enderecoRepository.save(enderecoRequest.toEndereco())
            val cliente: Cliente = clienteRequest.toCliente(enderecoSaldo)
            val clienteSalvo = repository.save(cliente)
            val clienteResponse: ClienteResponse = ClienteResponse(nome = clienteSalvo.nome,email = clienteSalvo.email)
            return clienteResponse
        }
        throw RuntimeException("Erro ao cadastrar Cliente")
    }
}