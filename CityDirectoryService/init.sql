 CREATE TABLE IF NOT EXISTS address (
     id SERIAL PRIMARY KEY,
     city VARCHAR(255),
     country VARCHAR(255),
     street VARCHAR(255),
     house_number VARCHAR(50)
 );

 CREATE TABLE IF NOT EXISTS working_hours (
     id SERIAL PRIMARY KEY,
     from_time TIME NOT NULL,
     to_time TIME NOT NULL
 );

 CREATE TABLE IF NOT EXISTS location (
     id SERIAL PRIMARY KEY,
     latitude DOUBLE PRECISION,
     longitude DOUBLE PRECISION
 );

CREATE TABLE facility_details (
    id SERIAL PRIMARY KEY,
    working_hours_id INT REFERENCES working_hours(id) ON DELETE SET NULL,
    address_id INT REFERENCES address(id) ON DELETE SET NULL
);


CREATE TABLE IF NOT EXISTS contact_details (
    id SERIAL PRIMARY KEY,
    phone_number VARCHAR(20),
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS government_office (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL,
    location_id INT REFERENCES location(id) ON DELETE SET NULL,
    details_id INT REFERENCES facility_details(id) ON DELETE CASCADE,
    contact_details_id INT REFERENCES contact_details(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS amenity (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL,
    location_id INT REFERENCES location(id) ON DELETE SET NULL,
    details_id INT REFERENCES facility_details(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS faq (
    id SERIAL PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    answer TEXT NOT NULL,
    category VARCHAR(50) NOT NULL
);
