package npa.crategame.crategameinterface.application.port.input

import npa.crategame.crategameinterface.domain.model.Item

interface ItemUseCase {
    fun getVersion(): Int
    fun getItems(): List<Item>
    fun getItem(id: String): Item?
}