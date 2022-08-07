package demo.shop

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface Repository: CrudRepository<ShopTable, Number>