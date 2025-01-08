---- Drug Table Schema
--CREATE TABLE drug (
--    drug_id SERIAL PRIMARY KEY,                -- Auto-generated unique ID for each drug
--    drug_name VARCHAR(100) NOT NULL,           -- Name of the drug
--    manufacturer VARCHAR(100),                 -- Manufacturer of the drug
--    manufacture_date DATE,                     -- Manufacturing date of the drug
--    expiry_date DATE,                          -- Expiry date of the drug
--    drug_type VARCHAR(50),                     -- Type of drug (e.g., OTC, Prescription)
--    price NUMERIC(10, 2) NOT NULL,             -- Price of the drug
--    dosage_form VARCHAR(50),                   -- Form of the drug (e.g., Tablet, Capsule)
--    strength VARCHAR(50),                      -- Strength of the drug (e.g., 500mg)
--    quantity INT NOT NULL,                     -- Quantity available
--    side_effects TEXT,                         -- Possible side effects
--    instructions TEXT,                         -- Usage instructions
--    generic_availability BOOLEAN               -- Whether a generic version is available (true/false)
--);



---- Location table
--CREATE TABLE IF NOT EXISTS location (
--    location_id SERIAL PRIMARY KEY,
--    address VARCHAR(255) NOT NULL,
--    zipcode VARCHAR(10) NOT NULL,
--    UNIQUE (address, zipcode) -- Prevent duplicate locations
--);



---- DrugLocation table
--CREATE TABLE IF NOT EXISTS drug_location (
--    drug_location_id SERIAL PRIMARY KEY,
--    drug_id INT NOT NULL,
--    location_id INT NOT NULL,
--    quantity_in_stock INT NOT NULL,
--    FOREIGN KEY (drug_id) REFERENCES drug_details (drug_id) ON DELETE CASCADE,
--    FOREIGN KEY (location_id) REFERENCES location (location_id) ON DELETE CASCADE
--);



---- Indexes for faster lookups
--CREATE INDEX IF NOT EXISTS idx_drug_id ON drug_location (drug_id);
--CREATE INDEX IF NOT EXISTS idx_location_id ON drug_location (location_id);
