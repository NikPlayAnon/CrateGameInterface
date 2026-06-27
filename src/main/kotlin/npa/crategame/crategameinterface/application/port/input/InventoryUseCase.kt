package npa.crategame.crategameinterface.application.port.input

import npa.crategame.crategameinterface.domain.model.InventoryEntry
import java.util.UUID

interface InventoryUseCase {
    fun getInventory(playerId: UUID): List<InventoryEntry>
    fun setInventory(playerId: UUID, entries: List<InventoryEntry>)
}