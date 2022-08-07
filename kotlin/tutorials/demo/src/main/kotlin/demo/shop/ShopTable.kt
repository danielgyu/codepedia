package demo.shop

import org.springframework.data.relational.core.mapping.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "shops")
class ShopTable(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    var id: Int? = null,

    @Column("name")
    var name: String,
)
