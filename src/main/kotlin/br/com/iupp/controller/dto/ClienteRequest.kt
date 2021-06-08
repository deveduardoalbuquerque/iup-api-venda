package br.com.iupp.controller.dto

import br.com.iupp.model.Cliente
import br.com.iupp.model.Endereco
import io.micronaut.core.annotation.Introspected
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Introspected
data class ClienteRequest(
    @NotBlank
    val nome:String,
    @NotBlank @Email
    val email:String,
    @NotBlank @CPF
    val cpf:String,
){
    fun toCliente(endereco: Endereco): Cliente {
        return Cliente(nome = nome, email = email,cpf=cpf,endereco = endereco)
    }
}