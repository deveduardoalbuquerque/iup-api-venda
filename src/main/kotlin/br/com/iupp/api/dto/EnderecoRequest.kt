package br.com.iupp.api.dto

import br.com.iupp.domain.model.Endereco
import javax.validation.constraints.NotBlank

data class EnderecoRequest (
    @NotBlank
    val cep:String,
    val logradouro:String,
    val complemento:String,
    val bairro:String,
    @NotBlank
    val localidade:String,
    val uf:String
        ){

    fun toEndereco():Endereco{
        return Endereco(
            cep = this.cep,
            logradouro = this.logradouro,
            complemento = this.complemento,
            bairro = this.bairro,
            localidade = this.localidade,
            uf = this.uf)
    }

}
