# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table connection (
  id                        bigint auto_increment not null,
  connection_type_de        varchar(255),
  connection_type_en        varchar(255),
  constraint pk_connection primary key (id))
;

create table contact (
  connection_type_de        integer,
  connection_type_en        integer,
  constraint ck_contact_connection_type_de check (connection_type_de in (0,1)),
  constraint ck_contact_connection_type_en check (connection_type_en in ()))
;

create table degree (
  id                        bigint auto_increment not null,
  degree_de                 varchar(255),
  degree_en                 varchar(255),
  constraint pk_degree primary key (id))
;

create table education_institute (
  id                        bigint auto_increment not null,
  education_institute_tid   bigint,
  education_institute       varchar(255),
  constraint pk_education_institute primary key (id))
;

create table educationlevel (
  id                        bigint auto_increment not null,
  education                 varchar(255),
  constraint pk_educationlevel primary key (id))
;

create table emergency_contact (
  emergency_surname         varchar(255),
  emergency_name            varchar(255))
;

create table emergency_relation (
  id                        bigint auto_increment not null,
  emergency_relation_de     varchar(255),
  emergency_relation_en     varchar(255),
  constraint pk_emergency_relation primary key (id))
;

create table faculty (
  id                        bigint auto_increment not null,
  faculty_de                varchar(255),
  faculty_en                varchar(255),
  constraint pk_faculty primary key (id))
;

create table human (
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime)
;

create table sex (
  id                        bigint auto_increment not null,
  sex_de                    varchar(255),
  sex_en                    varchar(255),
  constraint pk_sex primary key (id))
;

create table sizes (
  jacket_size               integer,
  trousers_size             integer,
  shoe_size                 integer)
;

create table translation (
  id                        bigint auto_increment not null,
  german                    varchar(255),
  english                   varchar(255),
  constraint pk_translation primary key (id))
;

create table volunteer (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  password                  varchar(255),
  id_text_boxes             bigint,
  id_event_comment          bigint,
  constraint pk_volunteer primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table connection;

drop table contact;

drop table degree;

drop table education_institute;

drop table educationlevel;

drop table emergency_contact;

drop table emergency_relation;

drop table faculty;

drop table human;

drop table sex;

drop table sizes;

drop table translation;

drop table volunteer;

SET FOREIGN_KEY_CHECKS=1;

