package br.com.iupp.infra.repository

import br.com.iupp.domain.model.Endereco
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface EnderecoRepository: JpaRepository<Endereco, Long> {
}