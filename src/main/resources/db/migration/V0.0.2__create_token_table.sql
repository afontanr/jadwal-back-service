CREATE TABLE IF NOT EXISTS tokens(
    id_token varchar(255) PRIMARY KEY,
    id_user varchar(255),
    id_rol varchar(255),
    FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_rol) REFERENCES roles(id_rol) ON DELETE CASCADE
);