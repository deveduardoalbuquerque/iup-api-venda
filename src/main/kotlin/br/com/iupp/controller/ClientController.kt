package br.com.iupp.controller

import br.com.iupp.controller.dto.ClientRequest
import br.com.iupp.controller.dto.ClientResponse
import br.com.iupp.service.ClientServiceImp
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api/v1/clientes")
class ClientController(val serviceImp: ClientServiceImp) {

    @Post("/{cep}")
    fun  cadastraUsuario(@Body @Valid clientRequest: ClientRequest,
                         @PathVariable cep:String): HttpResponse<ClientResponse> {
        return HttpResponse.ok(serviceImp.salvaCliente(clientRequest = clientRequest,cep = cep))
    }

}