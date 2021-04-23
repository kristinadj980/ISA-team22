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

INSERT INTO PHARMACY_INVENTORY(id) VALUES (8);

INSERT INTO PHARMACY(id, all_grades, description, name, number_of_grades, address_id, pharmacy_inventory_id) VALUES (50, 50,'First Pharmacy', 'Tilia', 10, 300, 8);

INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id) VALUES('Dermatologist', 100,'0655552525', 'derma@derma', true, false, 'Ivanovic', 'Mila', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id, main_admin) VALUES('SystemAdministrator', 101,'0655552525', 'pera@pera.com', true, true, 'Peric', 'Pera', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300, true);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id) VALUES('Pharmacist', 102,'0655552525', 'pharma@pharma', true, false, 'Mikic', 'Ivan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id) VALUES('Supplier', 103,'0657552525', 'mina@mina.com', true, true, 'Maric', 'Mina', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id,pharmacy_id) VALUES('PharmacyAdministrator', 104,'0657552525', 'marko@marko.com', true, true, 'Maric', 'Marko', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300,50);
INSERT INTO PERSON(dtype, id, contact, email, enabled, first_logged, last_name, name, password, address_id) VALUES('Supplier', 105,'0657552525', 'ana@ana.com', true, true, 'Maric', 'Ana', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 300);

INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (100, 3);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (101, 5);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (102, 2);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (103, 6);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (104, 4);
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (105, 6);





INSERT INTO PURCHASE_ORDER (id,due_date,purchase_order_status,pharmacy_administrator_id)
VALUES (401,'2021-05-12', 1,104);



INSERT INTO DRUG (id,code,name,producer)
VALUES (700,'M65','brufen','zegin');

INSERT INTO PURCHASE_ORDER_DRUG (id,amount,drug_id)
VALUES (600,7,700);

INSERT INTO PURCHASE_ORDER_PURCHASE_ORDER_DRUGS(purchase_order_id,purchase_order_drugs_id)
VALUES (401,600);

INSERT INTO DRUG (id,code,name,producer)
VALUES (701,'M35','aspirin','galenika');

INSERT INTO PURCHASE_ORDER_DRUG (id,amount,drug_id)
VALUES (601,65,701);



INSERT INTO SUPPLIER_DRUG_STOCK (id,code,name,quantity,reserved_quantity,supplier_id)
VALUES (800,67,'brufen',56,19,103);
INSERT INTO SUPPLIER_DRUG_STOCK (id,code,name,quantity,reserved_quantity,supplier_id)
VALUES (801,68,'probiotik',130,50,103);
INSERT INTO SUPPLIER_DRUG_STOCK (id,code,name,quantity,reserved_quantity,supplier_id)
VALUES (802,69,'andol',167,87,103);
INSERT INTO SUPPLIER_DRUG_STOCK (id,code,name,quantity,reserved_quantity,supplier_id)
VALUES (803,70,'panadol',145,24,103);



