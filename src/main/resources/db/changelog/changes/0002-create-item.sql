CREATE TABLE IF NOT EXISTS items (
                      id           VARCHAR(10)      NOT NULL,
                      display_name VARCHAR(100)     NOT NULL,
                      item_group   VARCHAR(50)      NOT NULL,
                      rarity       DOUBLE PRECISION NOT NULL,
                      icon_key     VARCHAR(100)     NOT NULL,

                      CONSTRAINT pk_item PRIMARY KEY (id)
);