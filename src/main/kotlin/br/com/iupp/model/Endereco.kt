package br.com.iupp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Endereco(
    val cep:String,
    val logradouro:String,
    val complemento:String,
    val bairro:String,
    val localidade:String,
    val uf:String,
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null
}