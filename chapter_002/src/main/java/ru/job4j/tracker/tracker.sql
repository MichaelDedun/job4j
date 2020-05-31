CREATE TABLE item (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

INSERT INTO item (name) VALUES (?);

