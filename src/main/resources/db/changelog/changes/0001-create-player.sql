CREATE TABLE player (
                        id          UUID        NOT NULL,
                        username    VARCHAR(50) NOT NULL,
                        created_at  TIMESTAMPTZ NOT NULL,
                        updated_at  TIMESTAMPTZ NOT NULL,

                        CONSTRAINT pk_player PRIMARY KEY (id),
                        CONSTRAINT uq_player_username UNIQUE (username)
);