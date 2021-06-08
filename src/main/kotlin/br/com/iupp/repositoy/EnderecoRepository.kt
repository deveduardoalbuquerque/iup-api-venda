package br.com.iupp.repositoy

import br.com.iupp.model.Endereco
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface EnderecoRepository: JpaRepository<Endereco, Long> {
}