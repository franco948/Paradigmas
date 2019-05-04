CREATE TABLE Plato (
pla_nombre varchar(30) PRIMARY KEY NOT NULL,
pla_precio float NOT NULL );
CREATE TABLE Plato_Ingrediente (
pla_nombre varchar(30) NOT NULL,
ing_nombre varchar(30) NOT NULL);
/* Inserta platos */
INSERT INTO Plato (pla_nombre, pla_precio) VALUES ('Milanesa', 70);
INSERT INTO Plato (pla_nombre, pla_precio) VALUES ('EnsaladaMixta', 50);
INSERT INTO Plato (pla_nombre, pla_precio) VALUES ('FideosConSalsa', 60);
/* Inserta ingredientes de un plato */
INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('Milanesa', 'CarneParaMilanesa');
INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('Milanesa', 'PanRallado');
INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('EnsaladaMixta', 'Lechuga');
INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('EnsaladaMixta', 'Tomate');
INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('EnsaladaMixta', 'Cebolla');
INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('FideosConSalsa', 'Fideos');
INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('FideosConSalsa', 'Salsa');