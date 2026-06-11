package npa.crategame.crategameinterface.adaptor.inbound.rest

import npa.crategame.crategameinterface.domain.model.Player
import java.time.Instant
import java.util.UUID

data class CreatePlayerRequest(val username: String) {
}

data class PlayerResponse(
    val id: UUID,
    val username: String,
    val createdAt: Instant
)

fun Player.toResponse() = PlayerResponse(
    id = id.value,
    username = username,
    createdAt = createdAt
)