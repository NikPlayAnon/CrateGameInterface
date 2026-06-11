package npa.crategame.crategameinterface.domain.exception

class PlayerNotFoundException(username: String): DomainException("Player $username not found") {
}