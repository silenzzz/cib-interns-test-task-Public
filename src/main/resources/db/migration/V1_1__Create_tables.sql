CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE socks
(
    id          serial primary key,
    color       varchar(255),
    cotton_part integer default 0,
    quantity    integer default 0,
    constraint stock_nonnegative check ( quantity >= 0)
)