package npa.crategame.crategameinterface.domain.exception

class ItemNotFoundException(id: String) : DomainException("item not found: $id") {
}