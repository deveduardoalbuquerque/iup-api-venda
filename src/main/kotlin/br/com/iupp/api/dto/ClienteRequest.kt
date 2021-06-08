package br.com.iupp.api.dto

import br.com.iupp.domain.model.Cliente
import br.com.iupp.domain.model.Endereco
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