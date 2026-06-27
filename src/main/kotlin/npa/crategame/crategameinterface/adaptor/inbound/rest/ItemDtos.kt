package npa.crategame.crategameinterface.adaptor.inbound.rest

import npa.crategame.crategameinterface.domain.model.Item
import npa.crategame.crategameinterface.infrastructure.config.AppProperties

data class ItemResponse(
    val id: String,
    val displayName: String,
    val group: String,
    val rarity: Double,
    val iconKey: String,
    val iconUrl: String,
) {
}

fun Item.toResponse(baseUrl: String) = ItemResponse(
    id = this.id,
    displayName = this.displayName,
    group = this.group,
    rarity = this.rarity,
    iconKey = this.iconKey,
    iconUrl = baseUrl
)