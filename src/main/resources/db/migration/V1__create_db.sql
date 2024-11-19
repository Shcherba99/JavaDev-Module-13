DROP SCHEMA IF EXISTS space_travel CASCADE;

CREATE SCHEMA IF NOT EXISTS space_travel;

CREATE TABLE IF NOT EXISTS space_travel.client(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(NAME) >= 3 AND LENGTH(NAME) <= 200)
);

CREATE TABLE IF NOT EXISTS space_travel.planet(
    id VARCHAR(50) PRIMARY KEY CHECK (id REGEXP '^[A-Z0-9]+$'),
    name VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1 AND LENGTH(name) <= 500)
);

CREATE TABLE IF NOT EXISTS space_travel.ticket(
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP,
    client_id INT,
    from_planet_id VARCHAR(50),
    to_planet_id VARCHAR(50),
    FOREIGN KEY (client_id) REFERENCES space_travel.client(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (from_planet_id) REFERENCES space_travel.planet(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (to_planet_id) REFERENCES space_travel.planet(id) ON UPDATE CASCADE ON DELETE CASCADE
);