package br.com.iupp.model

import javax.persistence.*

@Entity
class Client(
    val nome:String,
    val email:String,
    val cpf:String,
    @OneToOne
    val address: Address
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null
}