package br.com.iupp.domain.model

import javax.persistence.Entity

@Entity
class Endereco(
    val cep:String,
    val logradouro:String,
    val complemento:String,
    val bairro:String,
    val localidade:String,
    val uf:String,
) {
    val id:Long? = null
}