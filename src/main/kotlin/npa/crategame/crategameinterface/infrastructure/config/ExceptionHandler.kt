package npa.crategame.crategameinterface.infrastructure.config

import npa.crategame.crategameinterface.domain.exception.ItemNotFoundException
import npa.crategame.crategameinterface.domain.exception.PlayerAlreadyExistsException
import npa.crategame.crategameinterface.domain.exception.PlayerNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ExceptionHandler {
    @ExceptionHandler(PlayerAlreadyExistsException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handlerAlreadyExists(ex: PlayerAlreadyExistsException)=
        mapOf("error" to ex.message)

    @ExceptionHandler(PlayerNotFoundException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleNotFound(ex: PlayerAlreadyExistsException)=
        mapOf("error" to ex.message)

    @ExceptionHandler(ItemNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleItemNotFound(ex: ItemNotFoundException) =
        mapOf("error" to ex.message)
}
