package npa.crategame.crategameinterface.domain.model

import java.util.UUID

class InventoryEntry(
    val playerId: UUID,
    val defId: String,
    val quantity: Int
) {
}