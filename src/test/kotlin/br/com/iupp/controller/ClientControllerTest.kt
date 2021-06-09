package br.com.iupp.controller

import br.com.iupp.controller.ClientController
import br.com.iupp.controller.dto.ClientRequest
import br.com.iupp.controller.dto.ClientResponse
import br.com.iupp.service.ClientService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class ClientControllerTest: AnnotationSpec() {

    val clientService = mockk<ClientService>(relaxed = true)

    val clientController: ClientController = ClientController(clientService)

    val idClient:Long = 1

    lateinit var clienteRequest: ClientRequest
    lateinit var clienteResponse: ClientResponse

    @BeforeEach
    fun setUp() {
        clienteRequest = ClientRequest(nome = "Bia", "bia@email.com","12345679890")
        clienteResponse = ClientResponse("Bia", "bia@email.com")
    }

    @Test
    fun `should return sucess on insert method`() {
        every { clientService.create(any(),any()) } answers { clienteResponse }
        val result = clientController.cadastraUsuario(clienteRequest,"59067610").body()
        result shouldBe clienteResponse
    }

    fun `should return a client when find by id`(){
        every { clientService.findById(any()) } answers { clienteResponse}
        val result = clientController.findClientById(idClient)
        result shouldBe clienteResponse
    }

}