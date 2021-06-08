package br.com.iupp

import br.com.iupp.model.Cliente
import br.com.iupp.model.Endereco
import br.com.iupp.repositoy.ClienteRepository
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest
class ClienteControllerTest {

    @Inject
    lateinit var clienteRepository: ClienteRepository

    @Inject
    lateinit var cliente: Cliente


    @Inject
    @Client("/")
    lateinit var acesso:HttpClient


    @BeforeEach
    internal fun setup(){

        val endereco: Endereco = Endereco(
            "59067610",
            "Maçaranduba",
            "",
            "Pitibu",
            "Natal",
            "RN")

        cliente = Cliente("Bia","bia@email.com","12345678900",endereco)

        clienteRepository.save(cliente)
    }

    @Test
    internal fun `verificando os dados salvos em banco`() {
        val clienteEncontrado = clienteRepository.findById(1L).get()

        Assertions.assertEquals("Bia", clienteEncontrado.nome)
        Assertions.assertEquals("bia@email.com", clienteEncontrado.email)
        Assertions.assertEquals("12345678900", clienteEncontrado.cpf)

//        Mockito.`when`(clienteRepository.save(cliente))
//            .thenReturn(HttpResponse.ok(ClienteResponse))
//
    }

    @MockBean(Cliente::class)
    fun clienteMock(): Cliente {
        return Mockito.mock(Cliente::class.java)
    }

}