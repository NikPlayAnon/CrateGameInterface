package npa.crategame.crategameinterface.adaptor.inbound.rest

import npa.crategame.crategameinterface.domain.model.InventoryEntry
import java.util.UUID

data class InventoryEntryRequest(
    val defId: String,
    val quantity: Int,
)

data class InventoryEntryResponse(
    val defId: String,
    val quantity: Int,
)

fun InventoryEntry.toResponse() = InventoryEntryResponse(
    defId = defId,
    quantity = quantity
)

fun InventoryEntryRequest.toDomain(playerId: UUID) = InventoryEntry(
    playerId = playerId,
    defId = defId,
    quantity = quantity
)