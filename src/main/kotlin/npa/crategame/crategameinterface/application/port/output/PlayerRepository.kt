package npa.crategame.crategameinterface.application.port.output

import npa.crategame.crategameinterface.domain.model.Player
import npa.crategame.crategameinterface.domain.model.PlayerId

interface PlayerRepository {
    fun save(player: Player): Player
    fun existsByUsername(username: String): Boolean
    fun findById(id: PlayerId): Player?
}