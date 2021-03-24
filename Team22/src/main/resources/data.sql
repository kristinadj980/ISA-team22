INSERT INTO AUTHORITY (id ,name) VALUES (1, 'ROLE_PATIENT');
INSERT INTO AUTHORITY (id ,name) VALUES (2, 'ROLE_PHARMACIST');
INSERT INTO AUTHORITY (id ,name) VALUES (3, 'ROLE_DERMATOLOGIST');
INSERT INTO AUTHORITY (id ,name) VALUES (4, 'ROLE_PHARMACY_ADMINISTRATOR');
INSERT INTO AUTHORITY (id ,name) VALUES (5, 'ROLE_SYSTEM_ADMINISTRATOR');
INSERT INTO AUTHORITY (id ,name) VALUES (6, 'ROLE_SUPPLIER');
INSERT INTO AUTHORITY (id ,name) VALUES (7, 'ROLE_UNAUTHORISED');

INSERT INTO COUNTRY (id, name) VALUES (100, 'Srbija');
INSERT INTO COUNTRY (id, name) VALUES (101, 'Slovenija');

INSERT INTO CITY (id, name, country_id) VALUES (200, 'Novi Sad', 100);
INSERT INTO CITY (id, name, country_id) VALUES (201, 'Beograd', 100);
INSERT INTO CITY (id, name, country_id) VALUES (202, 'Ljubljana', 101);

INSERT INTO ADDRESS (id, street_name, street_number, city_id) VALUES (300, 'Kisacka', 55,201);

INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id) VALUES('Dermatologist', 100,'0655552525', 'derma@derma', true, false, 'Ivanovic', 'Ivan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id, main_admin) VALUES('SystemAdministrator', 101,'0655552525', 'pera@pera.com', true, true, 'Peric', 'Pera', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300, true);

INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (100, 3);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (101, 5);

