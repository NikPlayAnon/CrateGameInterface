package npa.crategame.crategameinterface.infrastructure.persistence

import npa.crategame.crategameinterface.application.port.output.ItemRepository
import npa.crategame.crategameinterface.domain.model.Item
import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.stereotype.Component
import java.sql.ResultSet

@Component
class ItemRepositoryAdapter(
    private val jdbc: JdbcClient
) : ItemRepository {
    override fun findAll(): List<Item> =
        jdbc.sql("SELECT * FROM items").query(::mapRow).list()

    override fun findById(id: String): Item? =
        jdbc.sql("SELECT * FROM items WHERE id = ?")
            .param(id)
            .query(::mapRow)
            .optional()
            .orElse(null)

    private fun mapRow(rs: ResultSet, @Suppress("UNUSED_PARAMETER") rowNum: Int): Item = Item(
        id = rs.getString("id"),
        displayName = rs.getString("display_name"),
        group = rs.getString("item_group"),
        rarity = rs.getDouble("rarity"),
        iconKey = rs.getString("icon_key"),
    )

}