package npa.crategame.crategameinterface.infrastructure.persistence

import npa.crategame.crategameinterface.application.port.output.InventoryRepository
import npa.crategame.crategameinterface.domain.model.InventoryEntry
import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.UUID

@Component
class InventoryRepositoryAdapter(
    private val jdbc: JdbcClient
) : InventoryRepository {
    override fun findByPlayerId(playerId: UUID): List<InventoryEntry> =
        jdbc.sql("SELECT * FROM player_inventory WHERE player_id = ?")
            .param(playerId)
            .query(::mapRow)
            .list()

    override fun replaceAll(playerId: UUID, entries: List<InventoryEntry>) {
        jdbc.sql("DELETE FROM player_inventory WHERE player_id = ?")
            .param(playerId)
            .update()
        entries.forEach { entry ->
            jdbc.sql("INSERT INTO player_inventory (player_id, def_id, quantity) VALUES (?, ?, ?)")
                .params(playerId, entry.defId, entry.quantity)
                .update()
        }
    }

    private fun mapRow(rs: ResultSet, @Suppress("UNUSED_PARAMETER") rowNum: Int) = InventoryEntry(
        playerId = rs.getObject("player_id", UUID::class.java),
        defId = rs.getString("def_id"),
        quantity = rs.getInt("quantity")
    )
}