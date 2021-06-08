package br.com.iupp.domain.model

import javax.persistence.*

@Entity
class Cliente(
    val nome:String,
    val email:String,
    val cpf:String,
    @OneToOne
    val endereco:Endereco
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null
}