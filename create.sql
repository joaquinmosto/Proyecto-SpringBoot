DROP TABLE IF EXISTS odontologos;
            CREATE TABLE odontologos(ID BIGINT PRIMARY KEY,
            NOMBRE VARCHAR(255) NOT NULL,
            APELLIDO VARCHAR(255) NOT NULL,
            MATRICULA BIGINT NOT NULL);