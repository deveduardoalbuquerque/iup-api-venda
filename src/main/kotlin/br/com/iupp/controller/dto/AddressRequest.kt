package br.com.iupp.controller.dto

import br.com.iupp.model.Address
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
data class AddressRequest (
    @NotBlank
    val cep:String,
    val logradouro:String,
    val complemento:String,
    val bairro:String,
    @NotBlank
    val localidade:String,
    val uf:String
        ){

    fun toEndereco(): Address {
        return Address(
            cep = this.cep,
            logradouro = this.logradouro,
            complemento = this.complemento,
            bairro = this.bairro,
            localidade = this.localidade,
            uf = this.uf)
    }

}
