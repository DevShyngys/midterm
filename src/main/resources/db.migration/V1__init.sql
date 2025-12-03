CREATE TABLE developer (
                           id BIGSERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           country VARCHAR(255)
);

CREATE TABLE platform (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          manufacturer VARCHAR(255)
);

CREATE TABLE game (
                      id BIGSERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      rating DOUBLE PRECISION,
                      developer_id BIGINT,
                      CONSTRAINT fk_developer FOREIGN KEY (developer_id) REFERENCES developer(id) ON DELETE SET NULL
);

CREATE TABLE game_platform (
                               game_id BIGINT NOT NULL,
                               platform_id BIGINT NOT NULL,
                               CONSTRAINT pk_game_platform PRIMARY KEY (game_id, platform_id),
                               CONSTRAINT fk_game FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE,
                               CONSTRAINT fk_platform FOREIGN KEY (platform_id) REFERENCES platform(id) ON DELETE CASCADE
);

