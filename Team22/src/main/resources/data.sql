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

INSERT INTO DERMATOLOGIST (id, contact, email, last_name, last_password_reset_date, name, password, username, address_id, all_grades, number_of_grades) VALUES (1,  '+381645554454', 'isa22project@gmail.com', 'Peric', '2017-10-01 ', 'Pera', 'pera', 'pera', 1, 5, 1);

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1,3);

