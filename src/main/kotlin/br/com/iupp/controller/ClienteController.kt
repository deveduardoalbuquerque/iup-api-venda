package br.com.iupp.controller

import br.com.iupp.controller.dto.ClienteRequest
import br.com.iupp.controller.dto.ClienteResponse
import br.com.iupp.service.ClienteService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api/v1/clientes")
class ClienteController(val service: ClienteService) {

    @Post("/{cep}")
    fun  cadastraUsuario(@Body @Valid clienteRequest: ClienteRequest,
                         @PathVariable cep:String): HttpResponse<ClienteResponse> {
        return HttpResponse.ok(service.salvaCliente(clienteRequest = clienteRequest,cep = cep))
    }

}