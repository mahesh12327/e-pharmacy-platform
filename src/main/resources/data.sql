---- Insert Sample Data into Drug Table
--INSERT INTO drug (drug_name, manufacturer, manufacture_date, expiry_date, drug_type, price, dosage_form, strength, quantity, side_effects, instructions, generic_availability)
--VALUES
--('Paracetamol', 'Manufacturer A', '2024-01-01', '2025-01-01', 'OTC', 10.50, 'Tablet', '500mg', 100, 'Nausea, Headache', 'Take after meals', true),
--('Ibuprofen', 'Manufacturer B', '2023-12-01', '2025-12-01', 'OTC', 15.00, 'Capsule', '200mg', 150, 'Drowsiness, Stomach upset', 'Do not exceed 2 tablets per day', true),
--('Amoxicillin', 'Manufacturer C', '2023-11-15', '2025-11-15', 'Prescription', 25.75, 'Tablet', '250mg', 200, 'Allergic reactions, Diarrhea', 'Take with water as prescribed', false),
--('Cetirizine', 'Manufacturer D', '2024-02-01', '2026-02-01', 'OTC', 8.25, 'Tablet', '10mg', 300, 'Drowsiness, Dry mouth', 'Take once daily', true),
--('Metformin', 'Manufacturer E', '2024-03-01', '2026-03-01', 'Prescription', 12.00, 'Tablet', '500mg', 400, 'Lactic acidosis, Nausea', 'Take with food', true),
--('Aspirin', 'Manufacturer F', '2023-10-01', '2025-10-01', 'OTC', 7.50, 'Tablet', '300mg', 250, 'Stomach pain, Heartburn', 'Take with water', true),
--('Loratadine', 'Manufacturer G', '2024-04-01', '2026-04-01', 'OTC', 5.75, 'Tablet', '10mg', 200, 'Drowsiness, Dry mouth', 'Take once daily as needed', true),
--('Simvastatin', 'Manufacturer H', '2023-09-01', '2025-09-01', 'Prescription', 30.00, 'Tablet', '20mg', 500, 'Muscle pain, Nausea', 'Take at night', false),
--('Clindamycin', 'Manufacturer I', '2023-08-01', '2025-08-01', 'Prescription', 18.50, 'Capsule', '300mg', 120, 'Diarrhea, Stomach upset', 'Follow prescribed dosage', false),
--('Omeprazole', 'Manufacturer J', '2024-05-01', '2026-05-01', 'OTC', 9.50, 'Capsule', '20mg', 350, 'Headache, Dizziness', 'Take before meals', true);





---- Insert Sample Data into Location Table
--INSERT INTO location (address, zipcode)
--VALUES
--    ('123 Main St, New York, NY', '10001'),
--    ('456 Elm St, Los Angeles, CA', '90001'),
--    ('789 Pine St, Chicago, IL', '60601'),
--    ('101 Maple St, Houston, TX', '77001'),
--    ('202 Oak St, San Francisco, CA', '94101');





---- Insert Sample Data into DrugLocation Table
--INSERT INTO drug_location (drug_id, location_id, quantity_in_stock)
--VALUES
--    -- Paracetamol
--    (1, 1, 200), -- Paracetamol at New York
--    (1, 2, 150), -- Paracetamol at Los Angeles
--
--    -- Ibuprofen
--    (2, 3, 120), -- Ibuprofen at Chicago
--
--    -- Amoxicillin
--    (3, 4, 100), -- Amoxicillin at Houston
--
--    -- Cetirizine
--    (4, 5, 300), -- Cetirizine at San Francisco
--    (4, 1, 180), -- Cetirizine at New York
--
--    -- Metformin
--    (5, 2, 400), -- Metformin at Los Angeles
--    (5, 4, 220), -- Metformin at Houston
--
--    -- Aspirin
--    (6, 3, 250), -- Aspirin at Chicago
--    (6, 5, 300), -- Aspirin at San Francisco
--
--    -- Loratadine
--    (7, 1, 200), -- Loratadine at New York
--
--    -- Simvastatin
--    (8, 2, 500), -- Simvastatin at Los Angeles
--
--    -- Clindamycin
--    (9, 4, 120), -- Clindamycin at Houston
--
--    -- Omeprazole
--    (10, 5, 350); -- Omeprazole at San Francisco
