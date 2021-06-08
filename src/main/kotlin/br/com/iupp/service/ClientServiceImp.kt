package br.com.iupp.service

import br.com.iupp.controller.dto.ClientRequest
import br.com.iupp.controller.dto.ClientResponse
import br.com.iupp.controller.dto.AddressRequest
import br.com.iupp.model.Client
import br.com.iupp.repositoy.ClientRepository
import br.com.iupp.repositoy.AddressRepository
import br.com.iupp.util.externo.BuscaEndereco
import java.lang.RuntimeException
import javax.inject.Singleton

@Singleton
class ClientServiceImp(val clientrepository: ClientRepository,
                       val addressRepository: AddressRepository,
                       val buscaEndereco: BuscaEndereco): ClientService {

    override fun create(clientRequest: ClientRequest, cep:String): ClientResponse {
        val addressRequest: AddressRequest = buscaEndereco.buscaEndereceoPorCEP(cep = cep)

        if(addressRequest != null){
            val enderecoSaldo = addressRepository.save(addressRequest.toEndereco())
            val client: Client = clientRequest.toClient(enderecoSaldo)
            val clienteSalvo = clientrepository.save(client)
            val clientResponse = ClientResponse(nome = clienteSalvo.nome,email = clienteSalvo.email)
            return clientResponse
        }

        throw RuntimeException("Erro ao cadastrar Cliente")
    }
}