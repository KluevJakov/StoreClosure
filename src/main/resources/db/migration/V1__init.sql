CREATE TABLE ADDRESS (
    id BIGINT NOT NULL,
    city VARCHAR(30),
    street VARCHAR(30),
    house VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE STORE (
    id BIGINT NOT NULL,
    phone VARCHAR(30),
    name VARCHAR(30),
    address_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (address_id) REFERENCES ADDRESS (id)
);