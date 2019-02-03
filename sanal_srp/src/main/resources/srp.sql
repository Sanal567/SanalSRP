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

 select
        student0_.student_id as student_1_13_,
        student0_.aid_additonal_info as aid_addi2_13_,
        student0_.caste as caste3_13_,
        student0_.commuting_by as commutin4_13_,
        student0_.commuting_from as commuti28_13_,
        student0_.created_by as created_5_13_,
        student0_.creation_date as creation6_13_,
        student0_.disability as disabili7_13_,
        student0_.disability_additional_info as disabili8_13_,
        student0_.edu_aadhar_no as edu_aadh9_13_,
        student0_.student_name as student10_13_,
        student0_.identification_mark_one as identif11_13_,
        student0_.identification_mark_two as identif12_13_,
        student0_.student_surname as student13_13_,
        student0_.last_updated_by as last_up14_13_,
        student0_.last_updation_date as last_up15_13_,
        student0_.past_edu_additional_info as past_ed16_13_,
        student0_.permanent_address_id as permane29_13_,
        student0_.poc_contact_no as poc_con17_13_,
        student0_.poc_name as poc_nam18_13_,
        student0_.relation as relatio19_13_,
        student0_.present_address_id as present30_13_,
        student0_.previous_class as previou20_13_,
        student0_.previous_school_id as previou31_13_,
        student0_.religion as religio21_13_,
        student0_.required_aid as require22_13_,
        student0_.student_aadhar_no as student23_13_,
        student0_.student_dob as student24_13_,
        student0_.student_extra_uq_no as student25_13_,
        student0_.student_gender as student26_13_,
        student0_.tc_number as tc_numb27_13_ 
    from
        sanal.students student0_ 
    where
        lower(student0_.student_name) like '%san%' escape '!' 
        or lower(student0_.student_surname) like '%nal%' escape '!';
