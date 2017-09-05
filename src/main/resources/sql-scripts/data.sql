INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
--INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'john.doe');
--INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'admin.admin');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'Philip', 'Yang', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', '1234567');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', '9999999');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

-- Populate random city table

INSERT INTO random_city(id, name) VALUES (1, 'Beijing');
INSERT INTO random_city(id, name) VALUES (2, 'Hong Kong');
INSERT INTO random_city(id, name) VALUES (3, 'Singapore');
INSERT INTO random_city(id, name) VALUES (4, 'Toronto');
INSERT INTO random_city(id, name) VALUES (5, 'New York');
INSERT INTO random_city(id, name) VALUES (6, 'San Francisco');
INSERT INTO random_city(id, name) VALUES (7, 'San Jose');
INSERT INTO random_city(id, name) VALUES (8, 'Boston');
