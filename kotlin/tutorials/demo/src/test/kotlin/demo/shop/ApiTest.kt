package demo.shop

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ApiTest {

    @Test
    fun testGetAllShops() {
        val service = mockk<Service>()
        val api = Api(service)
        val shops = listOf(Shop("KFC"), Shop("lotteria"))

        every { service.getAllShops() } returns shops

        assertEquals(shops, api.getAllShops())
    }
}