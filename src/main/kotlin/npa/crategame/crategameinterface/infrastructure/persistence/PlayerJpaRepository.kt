package npa.crategame.crategameinterface.infrastructure.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PlayerJpaRepository : JpaRepository<PlayerEntity, UUID> {
    fun existsByUsername(username: String): Boolean
}