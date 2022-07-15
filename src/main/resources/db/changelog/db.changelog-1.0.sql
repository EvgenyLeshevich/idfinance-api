--liquibase formatted sql

--changeset evgeniy:1
CREATE TABLE IF NOT EXISTS cryptocurrency
(
    id        BIGSERIAL PRIMARY KEY,
    symbol    VARCHAR(32) NOT NULL UNIQUE,
    price_usd DECIMAL(12, 2) DEFAULT '0'
);
--rollback DROP TABLE cryptocurrency;