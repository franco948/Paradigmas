CREATE TABLE Bebida (
    beb_nombre varchar(30) NOT NULL,
    beb_tamaño int NOT NULl /* El tamaño esta en mililitros */,
    beb_precio float NOT NULL,
    PRIMARY KEY (beb_nombre, beb_tamaño));
INSERT INTO Bebida (beb_nombre, beb_tamaño, beb_precio) VALUES ('Cerveza Stella', 1000, 80);
INSERT INTO Bebida (beb_nombre, beb_tamaño, beb_precio) VALUES ('Porron Cerveza Stella', 350, 40);
INSERT INTO Bebida (beb_nombre, beb_tamaño, beb_precio) VALUES ('Coca cola', 600, 45);
INSERT INTO Bebida (beb_nombre, beb_tamaño, beb_precio) VALUES ('Agua sin gas', 500, 30);
