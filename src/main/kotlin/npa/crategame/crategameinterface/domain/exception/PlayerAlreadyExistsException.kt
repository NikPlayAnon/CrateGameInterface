package npa.crategame.crategameinterface.domain.exception

class PlayerAlreadyExistsException(username: String)
    : DomainException("Player $username is already exists")