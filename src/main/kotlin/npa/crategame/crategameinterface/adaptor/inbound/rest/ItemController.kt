package npa.crategame.crategameinterface.adaptor.inbound.rest

import npa.crategame.crategameinterface.application.port.input.ItemUseCase
import npa.crategame.crategameinterface.infrastructure.config.AppProperties
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController(
    private val itemUseCase: ItemUseCase,
    private val appProperties: AppProperties
) {
    @GetMapping("/version")
    fun getVersion() = mapOf("version" to itemUseCase.getVersion())

    @GetMapping
    fun getItems() = itemUseCase.getItems().map { it.toResponse(appProperties.baseUrl) }

    @GetMapping("/{id}")
    fun getItem(@PathVariable id: String) = itemUseCase.getItem(id)!!.toResponse(appProperties.baseUrl)
}