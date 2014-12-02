# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table actual_job (
  id                        bigint auto_increment not null,
  actual_job_tid            bigint,
  constraint pk_actual_job primary key (id))
;

create table additional_coach (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_additional_coach primary key (id))
;

create table additional_packet (
  packet_booked             tinyint(1) default 0,
  packet_paid               tinyint(1) default 0)
;

create table arrival (
  arrival_date              datetime,
  arrival_place_tid         bigint,
  arrival_flight_number     varchar(255),
  arrival_comment           varchar(255))
;

create table athlete (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_athlete primary key (id))
;

create table attachments (
  photo                     varbinary(255),
  copy_passport             varbinary(255),
  waiver                    varbinary(255))
;

create table availability (
  availability_start        datetime,
  availability_end          datetime,
  interest_in_assisting_before_event tinyint(1) default 0)
;

create table city_guest (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_city_guest primary key (id))
;

create table city_representative (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_city_representative primary key (id))
;

create table city_representative_guest (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_city_representative_guest primary key (id))
;

create table coach (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_coach primary key (id))
;

create table connection (
  id                        bigint auto_increment not null,
  connection_type_tid       varchar(255),
  constraint pk_connection primary key (id))
;

create table contact (
  id                        bigint auto_increment not null,
  connection_type           integer,
  connection_type_tid       bigint,
  constraint ck_contact_connection_type check (connection_type in (0,1)),
  constraint pk_contact primary key (id))
;

create table contractor (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_contractor primary key (id))
;

create table contractor_liaison_officer (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_contractor_liaison_officer primary key (id))
;

create table degree (
  id                        bigint auto_increment not null,
  degree_tid                bigint,
  constraint pk_degree primary key (id))
;

create table delegation_liaison_officer (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_delegation_liaison_officer primary key (id))
;

create table departure (
  departure_date            datetime,
  departure_place_tid       bigint,
  departure_flight_number   varchar(255),
  departure_comment         varchar(255))
;

create table education_institute (
  id                        bigint auto_increment not null,
  education_institute_tid   bigint,
  constraint pk_education_institute primary key (id))
;

create table educationlevel (
  id                        bigint auto_increment not null,
  education_tid             varchar(255),
  constraint pk_educationlevel primary key (id))
;

create table email (
  id                        bigint auto_increment not null,
  subject                   varchar(255),
  content                   varchar(255),
  attachement               varbinary(255),
  email_tid                 bigint,
  constraint pk_email primary key (id))
;

create table emergency_contact (
  emergency_surname         varchar(255),
  emergency_name            varchar(255))
;

create table emergency_relation (
  id                        bigint auto_increment not null,
  emergency_relation_tid    bigint,
  constraint pk_emergency_relation primary key (id))
;

create table event (
  eventname                 varchar(255),
  event_start               datetime,
  event_end                 datetime,
  event_discription_tid     varchar(255),
  volunteer_open            tinyint(1) default 0,
  dlo_open                  tinyint(1) default 0,
  icg_member_open           tinyint(1) default 0,
  clo_open                  tinyint(1) default 0,
  loc_open                  tinyint(1) default 0,
  media_open                tinyint(1) default 0)
;

create table event_comment (
  id                        bigint auto_increment not null,
  comment                   varchar(255),
  constraint pk_event_comment primary key (id))
;

create table event_data_volunteer (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  password                  varchar(255),
  id_text_boxes             bigint,
  id_event_comment          bigint,
  social_security_number    varchar(255),
  constraint pk_event_data_volunteer primary key (id))
;

create table faculty (
  id                        bigint auto_increment not null,
  faculty_tid               bigint,
  constraint pk_faculty primary key (id))
;

create table head_of_delegation (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_head_of_delegation primary key (id))
;

create table human (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_human primary key (id))
;

create table icgguest (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_icgguest primary key (id))
;

create table icgmember (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  password                  varchar(255),
  constraint pk_icgmember primary key (id))
;

create table icgmember_guest (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_icgmember_guest primary key (id))
;

create table interview (
  interview_date            datetime,
  volunteer_id              bigint,
  interviewer_id            bigint,
  interview_comment         varchar(255))
;

create table it_knowledge (
  id                        bigint auto_increment not null,
  it_knowledge_tid          bigint,
  constraint pk_it_knowledge primary key (id))
;

create table locliaison_officer (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_locliaison_officer primary key (id))
;

create table locmember (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_locmember primary key (id))
;

create table login_receiver (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  email                     varchar(255),
  group_t                   integer,
  constraint ck_login_receiver_group_t check (group_t in (0,1,2,3,4,5)),
  constraint pk_login_receiver primary key (id))
;

create table login_time (
  login                     datetime)
;

create table media (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  constraint pk_media primary key (id))
;

create table organization (
  id                        bigint auto_increment not null,
  organization_type         varchar(255),
  organization_name         varchar(255),
  organization_size         integer,
  visible_for               tinyint(1) default 0,
  constraint pk_organization primary key (id))
;

create table preferred_working_area (
  id                        bigint auto_increment not null,
  preferred_working_area_tid bigint,
  constraint pk_preferred_working_area primary key (id))
;

create table role (
  id                        bigint auto_increment not null,
  role_tid                  bigint,
  visible_for               tinyint(1) default 0,
  constraint pk_role primary key (id))
;

create table sex (
  id                        bigint auto_increment not null,
  sex_tid                   bigint,
  constraint pk_sex primary key (id))
;

create table sizes (
  jacket_size               integer,
  trousers_size             integer,
  shoe_size                 integer)
;

create table sport (
  id                        bigint auto_increment not null,
  sport_tid                 bigint,
  constraint pk_sport primary key (id))
;

create table sport_interest (
  id                        bigint auto_increment not null,
  sports_tid                bigint,
  constraint pk_sport_interest primary key (id))
;

create table training (
  training_name             varchar(255),
  trainingdate              datetime,
  trainingquota             varchar(255))
;

create table translation (
  id                        bigint auto_increment not null,
  german                    varchar(255),
  english                   varchar(255),
  constraint pk_translation primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  auth_token                varchar(255),
  email_address             varchar(256) not null,
  full_name                 varchar(256) not null,
  creation_date             datetime not null,
  constraint uq_user_email_address unique (email_address),
  constraint pk_user primary key (id))
;

create table user_login (
  name                      varchar(255),
  password                  varchar(255),
  first_login               datetime,
  last_login                datetime)
;

create table volunteer (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  sex                       tinyint(1) default 0,
  date_of_birth             datetime,
  id_text_boxes             bigint,
  id_event_comment          bigint,
  social_security_number    varchar(255),
  volunteer_agreement       varbinary(255),
  constraint pk_volunteer primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table actual_job;

drop table additional_coach;

drop table additional_packet;

drop table arrival;

drop table athlete;

drop table attachments;

drop table availability;

drop table city_guest;

drop table city_representative;

drop table city_representative_guest;

drop table coach;

drop table connection;

drop table contact;

drop table contractor;

drop table contractor_liaison_officer;

drop table degree;

drop table delegation_liaison_officer;

drop table departure;

drop table education_institute;

drop table educationlevel;

drop table email;

drop table emergency_contact;

drop table emergency_relation;

drop table event;

drop table event_comment;

drop table event_data_volunteer;

drop table faculty;

drop table head_of_delegation;

drop table human;

drop table icgguest;

drop table icgmember;

drop table icgmember_guest;

drop table interview;

drop table it_knowledge;

drop table locliaison_officer;

drop table locmember;

drop table login_receiver;

drop table login_time;

drop table media;

drop table organization;

drop table preferred_working_area;

drop table role;

drop table sex;

drop table sizes;

drop table sport;

drop table sport_interest;

drop table training;

drop table translation;

drop table user;

drop table user_login;

drop table volunteer;

SET FOREIGN_KEY_CHECKS=1;

