package npa.crategame.crategameinterface.application.service

import npa.crategame.crategameinterface.application.port.input.InventoryUseCase
import npa.crategame.crategameinterface.application.port.output.InventoryRepository
import npa.crategame.crategameinterface.domain.model.InventoryEntry
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class InventoryService(
    private val inventoryRepository: InventoryRepository
) : InventoryUseCase {
    override fun getInventory(playerId: UUID): List<InventoryEntry> =
        inventoryRepository.findByPlayerId(playerId)

    override fun setInventory(playerId: UUID, entries: List<InventoryEntry>) =
        inventoryRepository.replaceAll(playerId,entries)
}