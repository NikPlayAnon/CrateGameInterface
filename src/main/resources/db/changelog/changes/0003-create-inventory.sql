CREATE TABLE IF NOT EXISTS player_inventory (
                                                player_id   UUID        NOT NULL,
                                                def_id      VARCHAR(10) NOT NULL,
    quantity    INT         NOT NULL,

    CONSTRAINT pk_player_inventory PRIMARY KEY (player_id, def_id),
    CONSTRAINT fk_player_inventory_player FOREIGN KEY (player_id) REFERENCES player(id)
    );