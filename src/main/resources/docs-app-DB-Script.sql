-------------Database Script for Docs App--------------------

CREATE DATABASE docs;

\c docs

---------------Users table contains all users data-----------------

CREATE TABLE users
(
  user_id serial,
  email character varying(50) NOT NULL,
  active boolean,
  last_name character varying(30),
  name character varying(30) NOT NULL,
  password character varying(255),
  role character varying(20),
  CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

--------------Table Of Contents for storing filenames and titles----------

CREATE TABLE table_of_contents
(
  id serial,
  title character varying(30) NOT NULL,
  file_name character varying(50) NOT NULL
);

