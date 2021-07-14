CREATE TABLE flight(
    id SERIAL PRIMARY KEY,
    departure_place VARCHAR NOT NULL,
    destination VARCHAR NOT NULL,
    departure_date VARCHAR NOT NULL,
    departure_time VARCHAR NOT NULL,
    arrival_date VARCHAR NOT NULL,
    arrival_time VARCHAR NOT NULL
);