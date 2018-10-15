CREATE SCHEMA sanal;

CREATE TABLE users(
 user_id serial PRIMARY KEY,
 username VARCHAR (15) UNIQUE NOT NULL,
 password VARCHAR (60) NOT NULL,
 email VARCHAR (20),
 enabled bool NOT NULL DEFAULT true, 
 created_on TIMESTAMP,
 last_login TIMESTAMP
);

/*
CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username)
 );
*/

CREATE TABLE user_roles (
  user_role_id serial ,
  username varchar(15) NOT NULL,
  role varchar(10) NOT NULL,
  PRIMARY KEY (username, role),
--  UNIQUE KEY uni_username_role (role,username),
--  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
 );

CREATE TABLE role(
 role_id serial PRIMARY KEY,
 role_name VARCHAR (255) UNIQUE NOT NULL
);

CREATE TABLE account_role
(
  user_id integer NOT NULL,
  role_id integer NOT NULL,
  grant_date timestamp without time zone,
  PRIMARY KEY (user_id, role_id),
  CONSTRAINT account_role_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES role (role_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT account_role_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES account (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

INSERT INTO users(username,password,enabled)
VALUES ('sanal','$2a$10$5UN7bBHPtpgd1cH8diu0h.20Fply.C/ZD0nbb722kd0qtAWi.Fx2.', true);
INSERT INTO users(username,password,enabled)
VALUES ('vamsi','$2a$10$5UN7bBHPtpgd1cH8diu0h.20Fply.C/ZD0nbb722kd0qtAWi.Fx2.', true);

INSERT INTO user_roles (username, role)
VALUES ('sanal', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('sanal', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('vamsi', 'ROLE_USER');

SELECT username, password, enabled FROM sanal.users WHERE username='sanal';

postgresql create tables many to many
