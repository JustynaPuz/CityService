-- CREATE TABLE IF NOT EXISTS address (
--     id SERIAL PRIMARY KEY,
--     city VARCHAR(255),
--     country VARCHAR(255),
--     street VARCHAR(255),
--     house_number VARCHAR(50)
-- );

-- CREATE TABLE IF NOT EXISTS working_hours (
--     id SERIAL PRIMARY KEY,
--     from_time TIME,
--     to_time TIME
-- );

-- CREATE TABLE IF NOT EXISTS location (
--     id SERIAL PRIMARY KEY,
--     latitude DOUBLE PRECISION,
--     longitude DOUBLE PRECISION
-- );

-- CREATE TABLE IF NOT EXISTS facility_details (
--     id SERIAL PRIMARY KEY,
--     working_hours_id INT REFERENCES working_hours(id),
--     address_id INT REFERENCES address(id)
-- );

-- CREATE TABLE IF NOT EXISTS contact_details (
--     id SERIAL PRIMARY KEY,
--     phone_number VARCHAR(50),
--     email VARCHAR(255)
-- );

-- CREATE TABLE IF NOT EXISTS facility (
--     id SERIAL PRIMARY KEY,
--     location_id INT REFERENCES location(id),
--     name VARCHAR(255),
--     details_id INT REFERENCES facility_details(id)
-- );

-- CREATE TABLE IF NOT EXISTS government_office (
--     id SERIAL PRIMARY KEY,
--     facility_id INT REFERENCES facility(id),
--     contact_details_id INT REFERENCES contact_details(id)
-- );

-- CREATE TABLE IF NOT EXISTS amenity (
--     id SERIAL PRIMARY KEY,
--     facility_id INT REFERENCES facility(id),
--     category VARCHAR(50)
-- );

CREATE TABLE IF NOT EXISTS faq (
    id SERIAL PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    answer TEXT NOT NULL,
    category VARCHAR(50) NOT NULL
);
