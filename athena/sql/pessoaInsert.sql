INSERT INTO athena_pais(pais) VALUES ('Brasil');
INSERT INTO athena_pais(pais) VALUES ('Argentina');
INSERT INTO athena_pais(pais) VALUES ('Estados Unidos');

INSERT INTO athena_estado(estado, paisID) VALUES ('Paraná', 1);
INSERT INTO athena_estado(estado, paisID) VALUES ('São Paulo', 1);
INSERT INTO athena_estado(estado, paisID) VALUES ('Texas', 3);
INSERT INTO athena_estado(estado, paisID) VALUES ('North Carolina', 3);
INSERT INTO athena_estado(estado, paisID) VALUES ('California', 3);

INSERT INTO athena_cidade(cidade, estadoID) VALUES ('Paranguá', 1);
INSERT INTO athena_cidade(cidade, estadoID) VALUES ('São Paulo', 2);
INSERT INTO athena_cidade(cidade, estadoID) VALUES ('Austin', 3);
INSERT INTO athena_cidade(cidade, estadoID) VALUES ('San Franscico', 5);