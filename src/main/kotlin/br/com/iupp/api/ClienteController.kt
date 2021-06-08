package br.com.iupp.api

import br.com.iupp.api.dto.ClienteRequest
import br.com.iupp.api.dto.ClienteResponse
import br.com.iupp.domain.service.ClienteService
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
                         @PathVariable cep:String):ClienteResponse{
        return service.salvaCliente(clienteRequest = clienteRequest,cep = cep)
    }

}