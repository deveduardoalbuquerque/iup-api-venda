package br.com.iupp.util.externo

import br.com.iupp.controller.dto.AddressRequest
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client

@Client("https://viacep.com.br/ws")
interface BuscaEndereco {

    @Get("/{cep}/json/")
    fun buscaEndereceoPorCEP(@PathVariable cep:String): AddressRequest
}