package npa.crategame.crategameinterface.adaptor.inbound.rest

import npa.crategame.crategameinterface.application.port.input.InventoryUseCase
import npa.crategame.crategameinterface.application.service.InventoryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/players/{playerId}/inventory")
class InventoryController(
    private val inventoryUseCase: InventoryUseCase,
) {
    @GetMapping
    fun getInventory(@PathVariable("playerId") playerId: UUID): List<InventoryEntryResponse> =
        inventoryUseCase.getInventory(playerId).map { it.toResponse() }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun setInventory(
        @PathVariable("playerId") playerId: UUID,
        @RequestBody entries: List<InventoryEntryRequest>
    ) = inventoryUseCase.setInventory(playerId, entries.map { it.toDomain(playerId) })
}


