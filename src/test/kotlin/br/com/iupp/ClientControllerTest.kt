package br.com.iupp

import br.com.iupp.model.Address
import br.com.iupp.repositoy.ClientRepository
import io.micronaut.http.client.HttpClient
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest
class ClientControllerTest {

    @Inject
    lateinit var clientRepository: ClientRepository

    @Inject
    lateinit var client: br.com.iupp.model.Client


    @Inject
    @Client("/")
    lateinit var acesso:HttpClient


    @BeforeEach
    internal fun setup(){

        val address: Address = Address(
            "59067610",
            "Maçaranduba",
            "",
            "Pitibu",
            "Natal",
            "RN")

        client = br.com.iupp.model.Client("Bia","bia@email.com","12345678900",address)

        clientRepository.save(client)
    }

    @Test
    internal fun `verificando os dados salvos em banco`() {
        val clienteEncontrado = clientRepository.findById(1L).get()

        Assertions.assertEquals("Bia", clienteEncontrado.nome)
        Assertions.assertEquals("bia@email.com", clienteEncontrado.email)
        Assertions.assertEquals("12345678900", clienteEncontrado.cpf)

//        Mockito.`when`(clienteRepository.save(cliente))
//            .thenReturn(HttpResponse.ok(ClienteResponse))
//
    }

    @MockBean(Client::class)
    fun clienteMock(): br.com.iupp.model.Client {
        return Mockito.mock(Client::class.java)
    }

}