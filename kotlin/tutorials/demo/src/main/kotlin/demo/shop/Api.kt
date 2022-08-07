package demo.shop

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Api(val service: Service) {
    @GetMapping("/shops")
    fun getAllShops(): List<Shop> {
        return service.getAllShops();
    }

    @PostMapping("/shops")
    fun saveOneShop(@RequestBody shopDto: ShopDTO): Shop {
        return service.saveShop(shopDto);
    }
}