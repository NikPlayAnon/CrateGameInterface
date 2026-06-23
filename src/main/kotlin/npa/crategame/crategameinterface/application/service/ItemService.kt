package npa.crategame.crategameinterface.application.service

import npa.crategame.crategameinterface.application.port.input.ItemUseCase
import npa.crategame.crategameinterface.application.port.output.ItemRepository
import npa.crategame.crategameinterface.domain.exception.ItemNotFoundException
import npa.crategame.crategameinterface.domain.model.Item
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository
) : ItemUseCase {
    override fun getVersion() = CATALOG_VERSION
    override fun getItems(): List<Item> =  itemRepository.findAll()
    override fun getItem(id: String): Item =
        itemRepository.findById(id) ?: throw ItemNotFoundException(id)

    companion object{
        const val CATALOG_VERSION = 1
    }
}