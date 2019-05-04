/*CREATE TABLE Ingrediente (
    ing_nombre varchar(30) PRIMARY KEY NOT NULL,
    ing_tipo varchar(30) NOT NULL );*/
CREATE TABLE Plato (
pla_nombre varchar(30) PRIMARY KEY NOT NULL,
pla_precio float NOT NULL );
CREATE TABLE Plato_Ingrediente (
pla_nombre varchar(30) NOT NULL,
ing_nombre varchar(30) NOT NULL);
/* Inserta ingredientes *//*
INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Papa', 'Verdura');
INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('CarneParaMilanesa', 'Carne');
INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('PanRallado', 'Otros');
INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Huevo', 'Otros');
INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Lechuga', 'Verdura');
INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Tomate', 'Verdura');
INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Fideos', 'Pasta');
INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Salsa', 'Otros');
INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Cebolla', 'Verdura');*/
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