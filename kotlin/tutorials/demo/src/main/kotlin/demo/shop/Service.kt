package demo.shop

import org.springframework.stereotype.Service

data class ShopDTO(
    val name: String,
)

@Service
class Service(val repo: Repository) {
    fun getAllShops(): List<Shop> {
        val dbShops: Iterable<ShopTable> = repo.findAll();

        val shopList: MutableList<Shop> = mutableListOf();
        dbShops.forEach{ shopList.add(Shop(it.name)) }

        return shopList;
    }

    fun saveShop(shopDto: ShopDTO): Shop {
        val shop = Shop(shopDto.name)
        repo.save(ShopTable(name=shop.name))

        return shop;
    }
}