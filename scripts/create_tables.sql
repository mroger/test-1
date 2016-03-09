CREATE TABLE RENTAL (
  idRental BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  brand VARCHAR(64) NOT NULL,
  model VARCHAR(64) NOT NULL,
  year VARCHAR(4) NOT NULL,
  color VARCHAR(64) NOT NULL
);

CREATE TABLE ACCESSORY (
  idAccessory BIGINT UNSIGNED PRIMARY KEY,
  description VARCHAR(255) NOT NULL
);

INSERT INTO ACCESSORY (idAccessory, description) values (1, 'Vidros elétricos');
INSERT INTO ACCESSORY (idAccessory, description) values (2, 'Travas elétricas');
INSERT INTO ACCESSORY (idAccessory, description) values (3, 'Air Bag');
INSERT INTO ACCESSORY (idAccessory, description) values (4, 'Ar Condicionado');

CREATE TABLE RENTAL_ACCESSORY (
  idAccessory BIGINT UNSIGNED,
  idRental BIGINT UNSIGNED,
  CONSTRAINT uc_rental_accessory UNIQUE KEY (idAccessory, idRental),
  CONSTRAINT fk_rental FOREIGN KEY (idRental) REFERENCES RENTAL(idRental),
  CONSTRAINT fk_accessory FOREIGN KEY (idAccessory) REFERENCES ACCESSORY(idAccessory)
);