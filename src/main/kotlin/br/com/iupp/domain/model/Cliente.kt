package br.com.iupp.domain.model

import javax.persistence.Entity
import javax.persistence.OneToOne

@Entity
class Cliente(
    val nome:String,
    val email:String,
    val cpf:String,
    @OneToOne
    val endereco:Endereco
) {
    val id:Long? = null
}