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

INSERT INTO users (email,active,last_name,name,password,role) values('admin@doc.com',true,'admin','admin','$2a$10$pNOQHgXFKcfrqzdgsPI2oOBJlXaGiAWQqh8fy2sAV9cOtpzfiyBf.','ADMIN');

--------------Table Of Contents for storing filenames and titles----------

CREATE TABLE table_of_contents
(
  id serial,
  title character varying(30) NOT NULL,
  file_name character varying(50) NOT NULL
);

