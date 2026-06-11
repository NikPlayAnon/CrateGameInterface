package npa.crategame.crategameinterface.infrastructure.persistence

import npa.crategame.crategameinterface.application.port.output.PlayerRepository
import npa.crategame.crategameinterface.domain.model.Player
import npa.crategame.crategameinterface.domain.model.PlayerId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class PlayerRepositoryAdapter (private val jpaRepository: PlayerJpaRepository) : PlayerRepository{

    override fun save(player: Player): Player =
        jpaRepository.save(player.toEntity()).toDomain()


    override fun existsByUsername(username: String): Boolean =
        jpaRepository.existsByUsername(username)

    override fun findById(id: PlayerId): Player? =
        jpaRepository.findByIdOrNull(id.value)?.toDomain()

}