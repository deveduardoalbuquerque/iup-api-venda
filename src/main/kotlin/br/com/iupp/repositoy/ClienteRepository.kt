package br.com.iupp.repositoy

import br.com.iupp.model.Cliente
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ClienteRepository: JpaRepository<Cliente, Long> {
}