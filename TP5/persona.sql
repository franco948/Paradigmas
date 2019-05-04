CREATE TABLE Persona (
    per_nombre varchar(30) NOT NULL,
    per_apellido varchar(30) NOT NULL,
    per_edad int NOT NULL,
    per_soltero bit NOT NULL
);
INSERT INTO Persona (per_nombre, per_apellido, per_edad, per_soltero) VALUES ('Martin', 'Figueroa', 24, 0);
INSERT INTO Persona (per_nombre, per_apellido, per_edad, per_soltero) VALUES ('Hernan', 'Gomez', 32, 1);