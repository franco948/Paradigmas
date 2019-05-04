CREATE TABLE Promocion (
    pro_nombre varchar(30) PRIMARY KEY NOT NULL,
    pro_plato varchar(30) NOT NULL,
    pro_bebida varchar(30) NOT NULL,
    pro_precio float NOT NULL,
    FOREIGN KEY (pro_plato) REFERENCES Plato(pla_nombre),
    FOREIGN KEY (pro_bebida) REFERENCES Bebida(beb_nombre),
);
INSERT INTO Promocion (pro_nombre, pro_plato, pro_bebida, pro_precio) VALUES ('Mila con ensalada','Milanesa','Agua sin gas', 100);
INSERT INTO Promocion (pro_nombre, pro_plato, pro_bebida, pro_precio) VALUES ('Fideos con bebida','FideosConSalsa','Porron Cerveza Stella', 120);