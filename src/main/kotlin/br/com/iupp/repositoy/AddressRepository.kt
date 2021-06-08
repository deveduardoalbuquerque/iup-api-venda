package br.com.iupp.repositoy

import br.com.iupp.model.Address
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AddressRepository: JpaRepository<Address, Long> {
}