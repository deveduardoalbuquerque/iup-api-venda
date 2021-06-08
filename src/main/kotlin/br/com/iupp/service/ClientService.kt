package br.com.iupp.service

import br.com.iupp.controller.dto.ClientRequest
import br.com.iupp.controller.dto.ClientResponse
import javax.inject.Singleton

@Singleton
interface ClientService {

    fun create(clientReques: ClientRequest, cep:String):ClientResponse

}