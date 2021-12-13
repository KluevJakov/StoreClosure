INSERT INTO CLOSURETYPEENUM(closureType) VALUES(0),(1),(2),(3);

INSERT INTO address(id, city, street, house) VALUES(1, 'Moscow', 'Vavilova', '23');
INSERT INTO address(id, city, street, house) VALUES(2, 'Moscow', 'Arbat', '142A');
INSERT INTO address(id, city, street, house) VALUES(3, 'Moscow', 'Komsomolskaya', '452/1');
INSERT INTO address(id, city, street, house) VALUES(4, 'Moscow', 'Teatralnaya', '12');
INSERT INTO address(id, city, street, house) VALUES(5, 'Penza', 'Pushkina', '563B');
INSERT INTO address(id, city, street, house) VALUES(6, 'Ulyanovsk', 'Kolotushkina', '34/12');
INSERT INTO address(id, city, street, house) VALUES(7, 'Voronezh', 'Abrikosovaya', '253');
INSERT INTO address(id, city, street, house) VALUES(8, 'Omsk', 'Vinogradnaya', '9A/1');
INSERT INTO address(id, city, street, house) VALUES(9, 'Irkutsk', 'Tenistaya', '153');
INSERT INTO address(id, city, street, house) VALUES(10, 'Ulan-Ude', 'Sadovaya', '65C');

INSERT INTO store(id, phone, name, address_id) VALUES(1, '88002001453', 'MskSouvenir', 1);
INSERT INTO store(id, phone, name, address_id) VALUES(2, '88002227632', 'TSUM', 1);
INSERT INTO store(id, phone, name, address_id) VALUES(3, '88003001672', 'D&M', 2);
INSERT INTO store(id, phone, name, address_id) VALUES(4, '88002507356', 'Sputnik', 3);
INSERT INTO store(id, phone, name, address_id) VALUES(5, '88007404234', 'CFC', 4);
INSERT INTO store(id, phone, name, address_id) VALUES(6, '88002454122', 'SELLA', 5);
INSERT INTO store(id, phone, name, address_id) VALUES(7, '88000394524', 'Mobus', 5);
INSERT INTO store(id, phone, name, address_id) VALUES(8, '88009403453', 'StratoPhoto', 6);
INSERT INTO store(id, phone, name, address_id) VALUES(9, '88009267384', 'Magnat', 7);
INSERT INTO store(id, phone, name, address_id) VALUES(10, '88002539385', 'Fusion', 8);
INSERT INTO store(id, phone, name, address_id) VALUES(11, '88006748392', 'Eastland', 8);
INSERT INTO store(id, phone, name, address_id) VALUES(12, '88003928573', 'BrandShoes', 9);
INSERT INTO store(id, phone, name, address_id) VALUES(13, '88007928539', 'Black&White', 10);
INSERT INTO store(id, phone, name, address_id) VALUES(14, '88000524843', 'CormoCoffee', 2);
INSERT INTO store(id, phone, name, address_id) VALUES(15, '88002343452', 'SpecialKit', 1);