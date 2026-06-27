package npa.crategame.crategameinterface.application.port.output

import npa.crategame.crategameinterface.domain.model.InventoryEntry
import java.util.UUID

interface InventoryRepository {
    fun findByPlayerId(playerId: UUID): List<InventoryEntry>
    fun replaceAll(playerId: UUID, entries: List<InventoryEntry>)
}