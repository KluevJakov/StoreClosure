CREATE TABLE IF NOT EXISTS address (
    id INT,
    city VARCHAR(30),
    street VARCHAR(30),
    house VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS store (
    id INT,
    phone VARCHAR(30),
    name VARCHAR(30),
    address INT,
    PRIMARY KEY (id),
    FOREIGN KEY (address) REFERENCES address(id)
);