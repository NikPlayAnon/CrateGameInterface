package npa.crategame.crategameinterface.application.port.output

import npa.crategame.crategameinterface.domain.model.Item

interface ItemRepository {
    fun findAll(): List<Item>
    fun findById(id: String): Item?
}