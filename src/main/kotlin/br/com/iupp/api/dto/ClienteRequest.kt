package br.com.iupp.api.dto

import br.com.iupp.domain.model.Cliente
import br.com.iupp.domain.model.Endereco
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class ClienteRequest(
    @NotBlank
    val nome:String,
    @NotBlank @Email
    val email:String,
    @NotBlank @CPF
    val cpf:String,
    @NotBlank
    val cep:String
){
    fun toCliente(endereco: Endereco): Cliente {
        return Cliente(nome = nome, email = email,cpf=cpf,endereco = endereco)
    }
}