# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact (
  connection_type           integer,
  constraint ck_contact_connection_type check (connection_type in (0,1)))
;

create table human (
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime)
;

create table volunteer (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  password                  varchar(255),
  constraint pk_volunteer primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table contact;

drop table human;

drop table volunteer;

SET FOREIGN_KEY_CHECKS=1;

