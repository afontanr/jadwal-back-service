CREATE SCHEMA IF NOT EXISTS jadwal;

CREATE TABLE IF NOT EXISTS roles(
    id_rol varchar(255) PRIMARY KEY,
    description varchar(255)
);

CREATE TABLE IF NOT EXISTS states(
    id_state varchar(255) PRIMARY KEY,
    description varchar(255)
);

CREATE TABLE IF NOT EXISTS exams(
    id_exam varchar(255) PRIMARY KEY,
    description varchar(255),
    date_start varchar(255),
    date_end varchar(255)
);

CREATE TABLE IF NOT EXISTS intervals(
    id_interval varchar(255) PRIMARY KEY,
    description varchar(255)
);

CREATE TABLE IF NOT EXISTS users(
    id_user varchar(255) PRIMARY KEY,
    id_rol varchar(255) REFERENCES roles(id_rol) ON DELETE CASCADE,
    id_state varchar(255) REFERENCES states(id_state) ON DELETE CASCADE,
    name varchar(255),
    surname varchar(255),
    email varchar(255),
    password varchar(255),
    office varchar(255)
);

CREATE TABLE IF NOT EXISTS questions(
    id_question varchar(255) PRIMARY KEY,
    id_user varchar(255) REFERENCES users(id_user) ON DELETE CASCADE,
    id_exam varchar(255) REFERENCES exams(id_exam) ON DELETE CASCADE,
    description varchar(255)
);

CREATE TABLE IF NOT EXISTS availabilities(
    id_available varchar(255) PRIMARY KEY,
    id_question varchar(255) REFERENCES questions(id_question) ON DELETE CASCADE,
    id_interval varchar(255) REFERENCES intervals(id_interval) ON DELETE CASCADE,
    day varchar(255),
    capacity integer
);

CREATE TABLE IF NOT EXISTS bookings(
    id_booking varchar(255) PRIMARY KEY,
    id_available varchar(255) REFERENCES availabilities(id_available) ON DELETE CASCADE,
    id_state varchar(255) REFERENCES states(id_state) ON DELETE CASCADE,
    email varchar(255),
    created_at varchar(255)
);



