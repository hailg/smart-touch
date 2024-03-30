CREATE TABLE contacts
(
    id          uuid DEFAULT uuid_generate_v4(),
    first_name  text NOT NULL,
    middle_name text,
    last_name   text NOT NULL,
    email       text NOT NULL,
    phone       text,
    PRIMARY KEY (id)
);