INSERT INTO AUTHORITY (id ,name) VALUES (1, 'ROLE_PATIENT');
INSERT INTO AUTHORITY (id ,name) VALUES (2, 'ROLE_PHARMACIST');
INSERT INTO AUTHORITY (id ,name) VALUES (3, 'ROLE_DERMATOLOGIST');
INSERT INTO AUTHORITY (id ,name) VALUES (4, 'ROLE_PHARMACY_ADMINISTRATOR');
INSERT INTO AUTHORITY (id ,name) VALUES (5, 'ROLE_SYSTEM_ADMINISTRATOR');
INSERT INTO AUTHORITY (id ,name) VALUES (6, 'ROLE_SUPPLIER');
INSERT INTO AUTHORITY (id ,name) VALUES (7, 'ROLE_UNAUTHORISED');

INSERT INTO COUNTRY (id, name) VALUES (1100, 'Srbija');
INSERT INTO COUNTRY (id, name) VALUES (1101, 'Slovenija');

INSERT INTO CITY (id, name, country_id) VALUES (200, 'Novi Sad', 1100);
INSERT INTO CITY (id, name, country_id) VALUES (201, 'Beograd', 1100);
INSERT INTO CITY (id, name, country_id) VALUES (202, 'Ljubljana', 1101);

INSERT INTO ADDRESS (id, street_name, street_number, city_id) VALUES (300, 'Kisacka', 55,201);
INSERT INTO ADDRESS (id, street_name, street_number, city_id) VALUES (301, 'Kisacka', 77,200);
INSERT INTO ADDRESS (id, street_name, street_number, city_id) VALUES (302, 'Brace Ribnikara', 88,200);
INSERT INTO ADDRESS (id, street_name, street_number, city_id) VALUES (303, 'Sekspirova', 99,200);
INSERT INTO ADDRESS (id, street_name, street_number, city_id) VALUES (304, 'Dalmatinska', 65,201);

INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id) VALUES('Dermatologist', 100,'0655552525', 'derma@derma', true, false, 'Ivanovic', 'Mila', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id, main_admin) VALUES('SystemAdministrator', 101,'0655552525', 'pera@pera.com', true, true, 'Peric', 'Pera', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300, true);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id) VALUES('Pharmacist', 102,'0655552525', 'pharma@pharma', true, false, 'Taric', 'Tara', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id) VALUES('Patient', 103,'06201023325', 'mina@mina', true, false, 'Minic', 'Mina', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 302);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id) VALUES('Patient', 104,'06256306363', 'miki@miki', true, false, 'Mikic', 'Miki', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 303);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id) VALUES('Patient', 105,'06125478958', 'ana@ana', true, false, 'Anic', 'Ana', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 304);

INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (100, 3);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (101, 5);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (102, 2);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (103, 1);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (104, 1);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (105, 1);

-- Dermatologist task 3.14
INSERT INTO PERIOD(id, end_date, end_time, start_date, start_time) VALUES (40, '2021-05-10', '15:00', '2021-05-10', '07:00' );
INSERT INTO PERIOD(id, end_date, end_time, start_date, start_time) VALUES (41, '2021-05-11', '15:00', '2021-05-11', '07:00' );
INSERT INTO PERIOD(id, end_date, end_time, start_date, start_time) VALUES (42, '2021-05-12', '20:00', '2021-05-12', '13:00' );
INSERT INTO PERIOD(id, end_date, end_time, start_date, start_time) VALUES (43, '2021-05-13', '15:00', '2021-05-13', '07:00' );
INSERT INTO PERIOD(id, end_date, end_time, start_date, start_time) VALUES (44, '2021-05-14', '20:00', '2021-05-14', '13:00' );
INSERT INTO PERIOD(id, end_date, end_time, start_date, start_time) VALUES (45, '2021-05-15', '20:00', '2021-05-15', '13:00' );

INSERT INTO PHARMACY_INVENTORY(id) VALUES (8);
INSERT INTO PHARMACY_INVENTORY(id) VALUES (9);

INSERT INTO PHARMACY(id, all_grades, counseling_price, description, examination_price, name, number_of_grades, address_id, pharmacy_inventory_id) VALUES (50, 50, 2000, 'First Pharmacy', 3000, 'Tilia', 10, 301, 8);
INSERT INTO PHARMACY(id, all_grades, counseling_price, description, examination_price, name, number_of_grades, address_id, pharmacy_inventory_id) VALUES (51, 50, 2000, 'Second Pharmacy', 5000, 'Tilia 2', 10, 300, 9);

INSERT INTO BUSINESS_DAY_DERMATOLOGIST(id, pharmacy_id, dermatologist_id, shift_id) VALUES (400, 50, 100, 40);
INSERT INTO BUSINESS_DAY_DERMATOLOGIST(id, pharmacy_id, dermatologist_id, shift_id) VALUES (401, 50, 100, 41);
INSERT INTO BUSINESS_DAY_DERMATOLOGIST(id, pharmacy_id, dermatologist_id, shift_id) VALUES (402, 50, 100, 42);
INSERT INTO BUSINESS_DAY_DERMATOLOGIST(id, pharmacy_id, dermatologist_id, shift_id) VALUES (403, 50, 100, 43);
INSERT INTO BUSINESS_DAY_DERMATOLOGIST(id, pharmacy_id, dermatologist_id, shift_id) VALUES (404, 51, 100, 44);
INSERT INTO BUSINESS_DAY_DERMATOLOGIST(id, pharmacy_id, dermatologist_id, shift_id) VALUES (405, 50, 100, 45);

INSERT INTO PHARMACY_DERMATOLOGISTS(dermatologist_id, pharmacy_id) VALUES (100, 50);
INSERT INTO PHARMACY_DERMATOLOGISTS(dermatologist_id, pharmacy_id) VALUES (100, 51);

INSERT INTO EXAMINATION(id, diagnosis, duration, examination_status, start_date, start_time, dermatologist_id, patient_id, pharmacy_id) VALUES (500, '', 30, 0, '2021-05-10', '08:30', 100, 103, 50);
INSERT INTO EXAMINATION(id, diagnosis, duration, examination_status, start_date, start_time, dermatologist_id, patient_id, pharmacy_id) VALUES (501, '', 30, 0, '2021-05-10', '10:30', 100, 105, 50);
INSERT INTO EXAMINATION(id, diagnosis, duration, examination_status, start_date, start_time, dermatologist_id, patient_id, pharmacy_id) VALUES (502, '', 30, 0, '2021-05-14', '16:30', 100, 105, 51);


