package npa.crategame.crategameinterface.adaptor.inbound.rest

import npa.crategame.crategameinterface.application.port.input.CreatePlayerCommand
import npa.crategame.crategameinterface.application.port.input.PlayerUseCase
import npa.crategame.crategameinterface.domain.model.PlayerId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/players")
class PlayerController(
    private val playerUseCase: PlayerUseCase,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPlayer(@RequestBody request: CreatePlayerRequest): PlayerResponse =
        playerUseCase.createPlayer(
            CreatePlayerCommand(username = request.username)
        ).toResponse()

    @GetMapping("/{id}")
    fun getPlayer(@PathVariable id: UUID): PlayerResponse =
        playerUseCase.getPlayer(PlayerId(id)).toResponse()
}