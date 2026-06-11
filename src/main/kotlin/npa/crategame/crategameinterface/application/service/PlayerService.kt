package npa.crategame.crategameinterface.application.service

import npa.crategame.crategameinterface.application.port.input.CreatePlayerCommand
import npa.crategame.crategameinterface.application.port.input.PlayerUseCase
import npa.crategame.crategameinterface.application.port.output.PlayerRepository
import npa.crategame.crategameinterface.domain.exception.PlayerAlreadyExistsException
import npa.crategame.crategameinterface.domain.exception.PlayerNotFoundException
import npa.crategame.crategameinterface.domain.model.Player
import npa.crategame.crategameinterface.domain.model.PlayerId
import org.springframework.stereotype.Service

@Service
class PlayerService(
    private val playerRepository: PlayerRepository,
) : PlayerUseCase {

    override fun createPlayer(command: CreatePlayerCommand): Player {
        if (playerRepository.existsByUsername(command.username)) {
            throw PlayerAlreadyExistsException(command.username)
        }
        return playerRepository.save(Player.create(command.username))
    }

    override fun getPlayer(id: PlayerId): Player {
        return playerRepository.findById(id)
            ?: throw PlayerNotFoundException(id.toString())
    }
}