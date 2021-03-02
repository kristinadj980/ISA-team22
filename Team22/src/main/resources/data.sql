INSERT INTO AUTHORITY (id ,name) VALUES (1, 'ROLE_PATIENT');
INSERT INTO AUTHORITY (id ,name) VALUES (2, 'ROLE_PHARMACIST');
INSERT INTO AUTHORITY (id ,name) VALUES (3, 'ROLE_DERMATOLOGIST');
INSERT INTO AUTHORITY (id ,name) VALUES (4, 'ROLE_PHARMACY_ADMINISTRATOR');
INSERT INTO AUTHORITY (id ,name) VALUES (5, 'ROLE_SYSTEM_ADMINISTRATOR');
INSERT INTO AUTHORITY (id ,name) VALUES (6, 'ROLE_SUPPLIER');
INSERT INTO AUTHORITY (id ,name) VALUES (7, 'ROLE_UNAUTHORISED');

INSERT INTO COUNTRY (id, name) VALUES (1, 'Srbija');
INSERT INTO COUNTRY (id, name) VALUES (2, 'Slovenija');

INSERT INTO CITY (id, name, country_id) VALUES (1, 'Novi Sad', 1);
INSERT INTO CITY (id, name, country_id) VALUES (2, 'Beograd', 1);
INSERT INTO CITY (id, name, country_id) VALUES (3, 'Ljubljana', 2);

INSERT INTO ADDRESS (id, street_name, street_number, city_id) VALUES (1, 'Kisacka', 55, 1);

INSERT INTO SYSTEM_ADMINISTRATOR (id, contact, email, enabled, first_logged, last_name, name, password, address_id,main_admin)
VALUES (1,'0608245666','pera@peric.com', true, true, 'peric', 'pera', '123', 1,true);

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1,5);

