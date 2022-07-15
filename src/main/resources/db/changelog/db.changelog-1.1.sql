--liquibase formatted sql

--changeset evgeniy:1
INSERT INTO cryptocurrency(id, symbol)
VALUES (90, 'BTC'),
       (80, 'ETH'),
       (48543, 'SOL');