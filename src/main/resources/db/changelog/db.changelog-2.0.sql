--liquibase formatted sql

--changeset evgeniy:1
CREATE TABLE IF NOT EXISTS users
(
    id            BIGSERIAL PRIMARY KEY,
    username      VARCHAR(32) NOT NULL,
    crypto_symbol VARCHAR(32) NOT NULL,
    crypto_price  DECIMAL(12, 2),
    UNIQUE (username, crypto_symbol)
);
--rollback DROP TABLE users;