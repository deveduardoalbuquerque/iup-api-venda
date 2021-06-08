package br.com.iupp.repositoy

import br.com.iupp.model.Client
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ClientRepository: JpaRepository<Client, Long> {
}