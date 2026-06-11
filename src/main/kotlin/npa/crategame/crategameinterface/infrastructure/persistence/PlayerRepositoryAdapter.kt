package npa.crategame.crategameinterface.infrastructure.persistence

import npa.crategame.crategameinterface.application.port.output.PlayerRepository
import npa.crategame.crategameinterface.domain.model.Player
import npa.crategame.crategameinterface.domain.model.PlayerId
import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.sql.Timestamp
import java.util.UUID

@Component
class PlayerRepositoryAdapter (
    private val jdbc: JdbcClient
) : PlayerRepository{

    override fun save(player: Player): Player {
        jdbc.sql("""
            INSERT INTO player (id, username, created_at, updated_at)
            VALUES (?,?,?,?)
            ON CONFLICT (id) DO UPDATE SET
                username = EXCLUDED.username,
                updated_at = EXCLUDED.updated_at
        """)
            .params(
                player.id.value,
                player.username,
                Timestamp.from(player.createdAt),
                Timestamp.from(player.updatedAt)
            ).update()
        return player
    }


    override fun existsByUsername(username: String): Boolean =
        jdbc.sql("SELECT COUNT(*) FROM player WHERE username = ?")
            .param(username)
            .query(Int::class.java)
            .single() > 0

    override fun findById(id: PlayerId): Player? =
        jdbc.sql("SELECT * FROM player WHERE id = ?")
            .param(id.value)
            .query(::mapRow)
            .optional()
            .orElse(null)

    private fun mapRow(rs: ResultSet, @Suppress("UNUSED_PARAMETER") rowNum: Int) = Player(
        id = PlayerId(rs.getObject("id", UUID::class.java)),
        username = rs.getString("username"),
        createdAt = rs.getTimestamp("created_at").toInstant(),
        updatedAt = rs.getTimestamp("updated_at").toInstant()
    )
}