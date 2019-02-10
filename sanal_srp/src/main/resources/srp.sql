
CREATE SCHEMA sanal;

CREATE TABLE users(
 user_id serial,
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

        
       ------------------------------------------------------------------
        
        Hibernate: 
    
    create table sanal.addresses (
       address_id  serial not null,
        additional_info varchar(50),
        created_by int4 not null,
        creation_date timestamp not null,
        district varchar(50) not null,
        door_or_house_no varchar(50),
        landmark varchar(50),
        last_updated_by int4 not null,
        last_updation_date timestamp not null,
        mandal varchar(50) not null,
        pin_no int4 not null check (pin_no<=699999 AND pin_no>=500000),
        street_one varchar(50) not null,
        street_two varchar(50),
        primary key (address_id)
    )
Hibernate: 
    
    create table sanal.admissions (
       admission_id  serial not null,
        admission_status varchar(1) not null,
        admitted_date date,
        created_by int4 not null,
        creation_date date not null,
        last_updated_by int4 not null,
        last_updation_date date not null,
        relieved_date date,
        student_id int4 not null,
        primary key (admission_id)
    )
Hibernate: 
    
    create table sanal.association_type (
       association_type_id  serial not null,
        association_category varchar(255),
        association_type_additional_info varchar(255),
        association_type_name varchar(255),
        createdBy int4,
        creation_date date,
        last_updated_by int4,
        last_updation_date date,
        primary key (association_type_id)
    )
Hibernate: 
    
    create table sanal.associations (
       association_id  serial not null,
        association_additional_info varchar(255),
        created_by int4,
        creation_date date,
        last_updated_by int4,
        last_updation_date date,
        that_id int4,
        this_id int4,
        association_type_id int4,
        primary key (association_id)
    )
Hibernate: 
    
    create table sanal.bill (
       bill_no  bigserial not null,
        bill_additonal_info varchar(255),
        bill_date timestamp,
        billed_amount float8,
        billed_by varchar(255),
        discount_amount float8,
        paid_by varchar(255),
        total_amount float8,
        primary key (bill_no)
    )
Hibernate: 
    
    create table sanal.class_section (
       class_section_id  serial not null,
        section_additional_info varchar(255),
        section_name varchar(255),
        section_id int4,
        class_id int4,
        primary key (class_section_id)
    )
Hibernate: 
    
    create table sanal.classes (
       class_id  serial not null,
        class_code varchar(255),
        class_desc varchar(255),
        class_name varchar(255),
        created_by int4,
        creation_date date,
        last_updated_by int4,
        last_updation_date date,
        primary key (class_id)
    )
Hibernate: 
    
    create table sanal.guardians (
       guardian_id  serial not null,
        created_by int4,
        creation_date timestamp,
        gender varchar(255),
        guardian_aadhar_no varchar(255),
        guardian_contact_no varchar(255),
        guardian_name varchar(255),
        guardian_occpation varchar(255),
        last_updated_by int4,
        last_updation_date timestamp,
        guardian_address_id int4,
        primary key (guardian_id)
    )
Hibernate: 
    
    create table sanal.labels (
       label_id  serial not null,
        created_by int4,
        creation_date date,
        label_additional_info varchar(255),
        label_category varchar(255),
        label_name varchar(255),
        last_updated_by int4,
        last_updation_date date,
        primary key (label_id)
    )
Hibernate: 
    
    create table sanal.payments (
       payment_id  bigserial not null,
        amount float8,
        class_code varchar(255),
        class_desc varchar(255),
        class_id int4,
        class_name varchar(255),
        discount_amount float8,
        student_extra_uq_no varchar(255),
        student_id int4,
        student_name varchar(255),
        student_surname varchar(255),
        total_amount float8,
        bill_no int8,
        primary key (payment_id)
    )
Hibernate: 
    
    create table sanal.schools (
       school_id  serial not null,
        created_by int4,
        creation_date timestamp,
        last_updated_by int4,
        last_updation_date varchar(255),
        school_code varchar(255),
        school_name varchar(255),
        address_id int4,
        primary key (school_id)
    )
Hibernate: 
    
    create table sanal.sections (
       section_id  serial not null,
        section_desc varchar(40),
        section_name varchar(20) not null,
        primary key (section_id)
    )
Hibernate: 
    
    create table sanal.student_guardian (
       student_guardian_id  serial not null,
        relation varchar(15) not null,
        guardian_id int4,
        student_id int4 not null,
        primary key (student_guardian_id)
    )
Hibernate: 
    
    create table sanal.students (
       student_id  serial not null,
        aid_additonal_info varchar(255),
        caste varchar(255),
        commuting_by varchar(255),
        created_by int4 not null,
        creation_date date not null,
        disability varchar(255),
        disability_additional_info varchar(255),
        edu_aadhar_no varchar(255),
        student_name varchar(50) not null,
        identification_mark_one varchar(255),
        identification_mark_two varchar(255),
        student_surname varchar(50) not null,
        last_updated_by int4 not null,
        last_updation_date date not null,
        past_edu_additional_info varchar(255),
        poc_contact_no varchar(255) not null,
        poc_name varchar(50) not null,
        relation varchar(255),
        previous_class varchar(255),
        religion varchar(255),
        required_aid varchar(255),
        student_aadhar_no varchar(255),
        student_dob varchar(255) not null,
        student_extra_uq_no varchar(255),
        student_gender boolean not null,
        tc_number varchar(255),
        commuting_from int4,
        permanent_address_id int4,
        present_address_id int4,
        previous_school_id int4,
        primary key (student_id)
    )
Hibernate: 
    
    alter table sanal.admissions 
       add constraint FKeg459scufsq5e326tjos9eyr8 
       foreign key (student_id) 
       references sanal.students
Hibernate: 
    
    alter table sanal.associations 
       add constraint FK5rwctnj9qvuc331kf4dutcqy5 
       foreign key (association_type_id) 
       references sanal.association_type
Hibernate: 
    
    alter table sanal.class_section 
       add constraint FKam245957af34bf31pedgak4sb 
       foreign key (section_id) 
       references sanal.sections
Hibernate: 
    
    alter table sanal.class_section 
       add constraint FK9bgmy2ueda94bep3oqwo8pudu 
       foreign key (class_id) 
       references sanal.classes
Hibernate: 
    
    alter table sanal.guardians 
       add constraint FKfje46480cm7btkiuajjxuo9hm 
       foreign key (guardian_address_id) 
       references sanal.addresses
Hibernate: 
    
    alter table sanal.payments 
       add constraint FKak2uigav72gr799k2fferen8j 
       foreign key (bill_no) 
       references sanal.bill
Hibernate: 
    
    alter table sanal.schools 
       add constraint FKa0xtp9j8pe50m5hr1fyobr9ug 
       foreign key (address_id) 
       references sanal.addresses
Hibernate: 
    
    alter table sanal.student_guardian 
       add constraint FKsmwo6yys2o7jriwss5g9efm9k 
       foreign key (guardian_id) 
       references sanal.guardians
Hibernate: 
    
    alter table sanal.student_guardian 
       add constraint FKk93rep5ghto6kxtthbluwd4vm 
       foreign key (student_id) 
       references sanal.students
Hibernate: 
    
    alter table sanal.students 
       add constraint FK9yehejw1teibraa3egbxlnosp 
       foreign key (commuting_from) 
       references sanal.addresses
Hibernate: 
    
    alter table sanal.students 
       add constraint FKq4v8q9ur9iwn6u9aihvbaw4u5 
       foreign key (permanent_address_id) 
       references sanal.addresses
Hibernate: 
    
    alter table sanal.students 
       add constraint FK5n6lmewr20nd4t27926x2qhs0 
       foreign key (present_address_id) 
       references sanal.addresses
Hibernate: 
    
    alter table sanal.students 
       add constraint FK9ke3gbl7bgvktg801brn7tov1 
       foreign key (previous_school_id) 
       references sanal.schools