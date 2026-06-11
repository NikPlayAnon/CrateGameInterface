package npa.crategame.crategameinterface.application.port.input

import npa.crategame.crategameinterface.domain.model.Player
import npa.crategame.crategameinterface.domain.model.PlayerId
import java.util.UUID

interface PlayerUseCase {
    fun createPlayer(command: CreatePlayerCommand) : Player
    fun getPlayer(id: PlayerId): Player
}

data class CreatePlayerCommand(
    val username: String
)