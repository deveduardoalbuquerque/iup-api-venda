package br.com.iupp.controller.dto

import br.com.iupp.model.Client
import br.com.iupp.model.Address
import io.micronaut.core.annotation.Introspected
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Introspected
data class ClientRequest(
    @NotBlank
    val nome:String,
    @NotBlank @Email
    val email:String,
    @NotBlank @CPF
    val cpf:String,
){
    fun toClient(address: Address): Client {
        return Client(nome = nome, email = email,cpf=cpf,address = address)
    }
}