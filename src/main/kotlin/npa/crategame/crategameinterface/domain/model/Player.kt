package npa.crategame.crategameinterface.domain.model

import java.time.Instant
import java.util.UUID

class Player(val id: PlayerId,
             val username: String,
             val createdAt: Instant,
             val updatedAt: Instant
) {
    override fun equals(other: Any?) = other is Player && id == other.id
    override fun hashCode() = id.hashCode()
}

@JvmInline
value class PlayerId(val value: UUID = UUID.randomUUID())