package npa.crategame.crategameinterface.infrastructure.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import npa.crategame.crategameinterface.domain.model.Player
import npa.crategame.crategameinterface.domain.model.PlayerId
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "player")
class PlayerEntity (
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    val id: UUID,

    @Column(name = "username", nullable = false, unique = true)
    val username: String,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: Instant,

    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
){
    // JPA requires this — plugin.jpa would generate it automatically
    protected constructor() : this(
        id = UUID.randomUUID(),
        username = "",
        createdAt = Instant.now(),
        updatedAt = Instant.now(),
    )
}

fun Player.toEntity() = PlayerEntity(
    id = id.value,
    username = username,
    createdAt = createdAt,
    updatedAt = updatedAt,
)

fun PlayerEntity.toDomain() = Player(
    id = PlayerId(id),
    username = username,
    createdAt = createdAt,
    updatedAt = updatedAt,
)