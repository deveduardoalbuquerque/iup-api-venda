package br.com.iupp.service

import br.com.iupp.controller.dto.AddressRequest
import br.com.iupp.controller.dto.ClientRequest
import br.com.iupp.controller.dto.ClientResponse
import br.com.iupp.model.Address
import br.com.iupp.model.Client
import br.com.iupp.repositoy.AddressRepository
import br.com.iupp.repositoy.ClientRepository
import br.com.iupp.service.ClientService
import br.com.iupp.service.ClientServiceImp
import br.com.iupp.util.externo.BuscaEndereco
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.fp.Option
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class ClientServiceTest:AnnotationSpec() {

    val clientRepository:ClientRepository = mockk<ClientRepository>(relaxed = true)
    val addressRepository:AddressRepository = mockk<AddressRepository>(relaxed = true)
    val buscaAddressByCEP:BuscaEndereco = mockk<BuscaEndereco>(relaxed = true)

    val clientService:ClientService = ClientServiceImp(clientRepository,addressRepository,buscaAddressByCEP)

    val idCliente:Long = 1

    lateinit var clientRequest: ClientRequest
    lateinit var clientResponse:ClientResponse
    lateinit var addressRequest: AddressRequest
    lateinit var address:Address
    lateinit var client:Client

    @BeforeEach
    fun setUp(){
        clientRequest = ClientRequest("bob","bob@email.com","12345678900")
        clientResponse = ClientResponse("bob","bob@email.com")
        addressRequest = AddressRequest("59067610","","","","Natal","RN")
        address = Address("59067610","","","","Natal","RN")
        client = Client("bob","bob@email.com","12345678900",address)
    }
    @Test
    fun `should return success on create client`(){
        every { buscaAddressByCEP.buscaEndereceoPorCEP(any()) } answers { addressRequest }
        every { addressRepository.save(any()) } answers {address}
        every { clientRepository.save(any()) } answers { client }
        var result = clientService.create( clientRequest,addressRequest.cep)
        result shouldBe clientResponse
    }

    @Test
    fun `should return success on find client by id`(){
        every { clientRepository.findById(any()) } answers { Optional.of(client) }
        var result = clientService.findById(idCliente)
        result shouldBe clientResponse
    }



}
