# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table area_of_interest (
  id                        bigint not null,
  interest                  varchar(255),
  constraint pk_area_of_interest primary key (id))
;

create table clothing_size (
  id                        bigint not null,
  size                      varchar(255),
  constraint pk_clothing_size primary key (id))
;

create table country (
  id                        bigint not null,
  iso3                      varchar(255),
  constraint pk_country primary key (id))
;

create table emergency_contact (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  phone_number              varchar(255),
  email                     varchar(255),
  constraint pk_emergency_contact primary key (id))
;

create table event (
  eventname                 varchar(255) not null,
  event_start               timestamp,
  event_end                 timestamp,
  constraint pk_event primary key (eventname))
;

create table gender (
  id                        bigint not null,
  gender                    varchar(255),
  translation_tid           bigint,
  constraint pk_gender primary key (id))
;

create table highest_education_level (
  id                        bigint not null,
  highest_education_level   varchar(255),
  translation_tid           bigint,
  constraint pk_highest_education_level primary key (id))
;

create table itmedia_skill (
  id                        bigint not null,
  it_media_skill            varchar(255),
  translation_tid           bigint,
  constraint pk_itmedia_skill primary key (id))
;

create table identification_type (
  id                        bigint not null,
  type                      varchar(255),
  translation_tid           bigint,
  constraint pk_identification_type primary key (id))
;

create table language (
  id                        bigint not null,
  language                  varchar(255),
  translation_tid           bigint,
  constraint pk_language primary key (id))
;

create table language_skill (
  id                        bigint not null,
  language_skill            varchar(255),
  translation_tid           bigint,
  constraint pk_language_skill primary key (id))
;

create table prefered_language (
  id                        bigint not null,
  prefered_language         varchar(255),
  translation_tid           bigint,
  constraint pk_prefered_language primary key (id))
;

create table profession (
  id                        bigint not null,
  profession                varchar(255),
  translation_tid           bigint,
  constraint pk_profession primary key (id))
;

create table shoe_size (
  id                        bigint not null,
  shoe_size                 float,
  constraint pk_shoe_size primary key (id))
;

create table sport_skill (
  id                        bigint not null,
  sport_skill               varchar(255),
  translation_tid           bigint,
  constraint pk_sport_skill primary key (id))
;

create table translation (
  tid                       bigint not null,
  german                    varchar(255),
  english                   varchar(255),
  constraint pk_translation primary key (tid))
;

create table user (
  username                  varchar(255) not null,
  password                  varchar(255),
  creation_time             timestamp,
  validated                 boolean,
  auth_token                varchar(255),
  last_login                timestamp,
  constraint pk_user primary key (username))
;

create table user_language_skill (
  id                        bigint not null,
  volunteer_id_id           bigint,
  language_id_id            bigint,
  language_skill_id         bigint,
  constraint pk_user_language_skill primary key (id))
;

create table user_login (
  username                  varchar(255) not null,
  password                  varchar(255),
  creation_time             timestamp,
  first_login               timestamp,
  last_login                timestamp,
  auth_token                varchar(255),
  chosen_language           varchar(255),
  mail_confirmation         boolean,
  volunteer_id              bigint,
  constraint pk_user_login primary key (username))
;

create table volunteer (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  sex_id                    bigint,
  birthday                  timestamp,
  user_username             varchar(255),
  mail                      varchar(255),
  social_security_number    integer,
  place_of_residence        varchar(255),
  plz                       varchar(255),
  adress                    varchar(255),
  country_id                bigint,
  phone_number              bigint,
  prefered_language_id      bigint,
  adress_confirmed          boolean,
  identification_type_id    bigint,
  id_number                 varchar(255),
  id_valid_until            timestamp,
  car_driving_license       boolean,
  emergency_contact_id      bigint,
  jacket_size_id            bigint,
  trouser_size_id           bigint,
  shoe_size_id              bigint,
  photo                     varchar(255),
  profession_id             bigint,
  highest_education_level_id bigint,
  university                varchar(255),
  field_of_profession       varchar(255),
  professional_career       varchar(255),
  mother_tongue_id          bigint,
  interpreting_languages    varchar(255),
  translating_languages     varchar(255),
  ms_office_skill_id        bigint,
  it_network_skill_id       bigint,
  content_management_skill_id bigint,
  graphic_skill_id          bigint,
  further_qualifications    varchar(255),
  events_participated       varchar(255),
  interested_icg2016        boolean,
  interested_skiing         boolean,
  interested_snowboarding   boolean,
  interested_cross_country_skiing boolean,
  interested_biathlon       boolean,
  interested_ice_skating    boolean,
  interested_ice_hockey     boolean,
  area_interest1_id         bigint,
  area_interest2_id         bigint,
  area_interest3_id         bigint,
  availability_beginning    timestamp,
  availability_end          timestamp,
  interested_icg2016prior_to_beginning boolean,
  icg2016comment            varchar(255),
  language_skills_professional varchar(255),
  training_skills_professional varchar(255),
  constraint pk_volunteer primary key (id))
;


create table volunteer_country (
  volunteer_id                   bigint not null,
  country_id                     bigint not null,
  constraint pk_volunteer_country primary key (volunteer_id, country_id))
;

create table volunteer_event (
  volunteer_id                   bigint not null,
  event_eventname                varchar(255) not null,
  constraint pk_volunteer_event primary key (volunteer_id, event_eventname))
;
create sequence area_of_interest_seq;

create sequence clothing_size_seq;

create sequence country_seq;

create sequence emergency_contact_seq;

create sequence event_seq;

create sequence gender_seq;

create sequence highest_education_level_seq;

create sequence itmedia_skill_seq;

create sequence identification_type_seq;

create sequence language_seq;

create sequence language_skill_seq;

create sequence prefered_language_seq;

create sequence profession_seq;

create sequence shoe_size_seq;

create sequence sport_skill_seq;

create sequence translation_seq;

create sequence user_seq;

create sequence user_language_skill_seq;

create sequence user_login_seq;

create sequence volunteer_seq;

alter table gender add constraint fk_gender_translation_1 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_gender_translation_1 on gender (translation_tid);
alter table highest_education_level add constraint fk_highest_education_level_tra_2 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_highest_education_level_tra_2 on highest_education_level (translation_tid);
alter table itmedia_skill add constraint fk_itmedia_skill_translation_3 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_itmedia_skill_translation_3 on itmedia_skill (translation_tid);
alter table identification_type add constraint fk_identification_type_transla_4 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_identification_type_transla_4 on identification_type (translation_tid);
alter table language add constraint fk_language_translation_5 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_language_translation_5 on language (translation_tid);
alter table language_skill add constraint fk_language_skill_translation_6 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_language_skill_translation_6 on language_skill (translation_tid);
alter table prefered_language add constraint fk_prefered_language_translati_7 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_prefered_language_translati_7 on prefered_language (translation_tid);
alter table profession add constraint fk_profession_translation_8 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_profession_translation_8 on profession (translation_tid);
alter table sport_skill add constraint fk_sport_skill_translation_9 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_sport_skill_translation_9 on sport_skill (translation_tid);
alter table user_language_skill add constraint fk_user_language_skill_volunt_10 foreign key (volunteer_id_id) references volunteer (id) on delete restrict on update restrict;
create index ix_user_language_skill_volunt_10 on user_language_skill (volunteer_id_id);
alter table user_language_skill add constraint fk_user_language_skill_langua_11 foreign key (language_id_id) references language (id) on delete restrict on update restrict;
create index ix_user_language_skill_langua_11 on user_language_skill (language_id_id);
alter table user_language_skill add constraint fk_user_language_skill_langua_12 foreign key (language_skill_id) references language_skill (id) on delete restrict on update restrict;
create index ix_user_language_skill_langua_12 on user_language_skill (language_skill_id);
alter table user_login add constraint fk_user_login_volunteer_13 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;
create index ix_user_login_volunteer_13 on user_login (volunteer_id);
alter table volunteer add constraint fk_volunteer_sex_14 foreign key (sex_id) references gender (id) on delete restrict on update restrict;
create index ix_volunteer_sex_14 on volunteer (sex_id);
alter table volunteer add constraint fk_volunteer_user_15 foreign key (user_username) references user (username) on delete restrict on update restrict;
create index ix_volunteer_user_15 on volunteer (user_username);
alter table volunteer add constraint fk_volunteer_country_16 foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_volunteer_country_16 on volunteer (country_id);
alter table volunteer add constraint fk_volunteer_preferedLanguage_17 foreign key (prefered_language_id) references prefered_language (id) on delete restrict on update restrict;
create index ix_volunteer_preferedLanguage_17 on volunteer (prefered_language_id);
alter table volunteer add constraint fk_volunteer_identificationTy_18 foreign key (identification_type_id) references identification_type (id) on delete restrict on update restrict;
create index ix_volunteer_identificationTy_18 on volunteer (identification_type_id);
alter table volunteer add constraint fk_volunteer_emergencyContact_19 foreign key (emergency_contact_id) references emergency_contact (id) on delete restrict on update restrict;
create index ix_volunteer_emergencyContact_19 on volunteer (emergency_contact_id);
alter table volunteer add constraint fk_volunteer_jacketSize_20 foreign key (jacket_size_id) references clothing_size (id) on delete restrict on update restrict;
create index ix_volunteer_jacketSize_20 on volunteer (jacket_size_id);
alter table volunteer add constraint fk_volunteer_trouserSize_21 foreign key (trouser_size_id) references clothing_size (id) on delete restrict on update restrict;
create index ix_volunteer_trouserSize_21 on volunteer (trouser_size_id);
alter table volunteer add constraint fk_volunteer_shoeSize_22 foreign key (shoe_size_id) references shoe_size (id) on delete restrict on update restrict;
create index ix_volunteer_shoeSize_22 on volunteer (shoe_size_id);
alter table volunteer add constraint fk_volunteer_profession_23 foreign key (profession_id) references profession (id) on delete restrict on update restrict;
create index ix_volunteer_profession_23 on volunteer (profession_id);
alter table volunteer add constraint fk_volunteer_highestEducation_24 foreign key (highest_education_level_id) references highest_education_level (id) on delete restrict on update restrict;
create index ix_volunteer_highestEducation_24 on volunteer (highest_education_level_id);
alter table volunteer add constraint fk_volunteer_motherTongue_25 foreign key (mother_tongue_id) references language (id) on delete restrict on update restrict;
create index ix_volunteer_motherTongue_25 on volunteer (mother_tongue_id);
alter table volunteer add constraint fk_volunteer_msOfficeSkill_26 foreign key (ms_office_skill_id) references itmedia_skill (id) on delete restrict on update restrict;
create index ix_volunteer_msOfficeSkill_26 on volunteer (ms_office_skill_id);
alter table volunteer add constraint fk_volunteer_itNetworkSkill_27 foreign key (it_network_skill_id) references itmedia_skill (id) on delete restrict on update restrict;
create index ix_volunteer_itNetworkSkill_27 on volunteer (it_network_skill_id);
alter table volunteer add constraint fk_volunteer_contentManagemen_28 foreign key (content_management_skill_id) references itmedia_skill (id) on delete restrict on update restrict;
create index ix_volunteer_contentManagemen_28 on volunteer (content_management_skill_id);
alter table volunteer add constraint fk_volunteer_graphicSkill_29 foreign key (graphic_skill_id) references itmedia_skill (id) on delete restrict on update restrict;
create index ix_volunteer_graphicSkill_29 on volunteer (graphic_skill_id);
alter table volunteer add constraint fk_volunteer_areaInterest1_30 foreign key (area_interest1_id) references area_of_interest (id) on delete restrict on update restrict;
create index ix_volunteer_areaInterest1_30 on volunteer (area_interest1_id);
alter table volunteer add constraint fk_volunteer_areaInterest2_31 foreign key (area_interest2_id) references area_of_interest (id) on delete restrict on update restrict;
create index ix_volunteer_areaInterest2_31 on volunteer (area_interest2_id);
alter table volunteer add constraint fk_volunteer_areaInterest3_32 foreign key (area_interest3_id) references area_of_interest (id) on delete restrict on update restrict;
create index ix_volunteer_areaInterest3_32 on volunteer (area_interest3_id);



alter table volunteer_country add constraint fk_volunteer_country_voluntee_01 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;

alter table volunteer_country add constraint fk_volunteer_country_country_02 foreign key (country_id) references country (id) on delete restrict on update restrict;

alter table volunteer_event add constraint fk_volunteer_event_volunteer_01 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;

alter table volunteer_event add constraint fk_volunteer_event_event_02 foreign key (event_eventname) references event (eventname) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists area_of_interest;

drop table if exists clothing_size;

drop table if exists country;

drop table if exists emergency_contact;

drop table if exists event;

drop table if exists volunteer_event;

drop table if exists gender;

drop table if exists highest_education_level;

drop table if exists itmedia_skill;

drop table if exists identification_type;

drop table if exists language;

drop table if exists language_skill;

drop table if exists prefered_language;

drop table if exists profession;

drop table if exists shoe_size;

drop table if exists sport_skill;

drop table if exists translation;

drop table if exists user;

drop table if exists user_language_skill;

drop table if exists user_login;

drop table if exists volunteer;

drop table if exists volunteer_country;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists area_of_interest_seq;

drop sequence if exists clothing_size_seq;

drop sequence if exists country_seq;

drop sequence if exists emergency_contact_seq;

drop sequence if exists event_seq;

drop sequence if exists gender_seq;

drop sequence if exists highest_education_level_seq;

drop sequence if exists itmedia_skill_seq;

drop sequence if exists identification_type_seq;

drop sequence if exists language_seq;

drop sequence if exists language_skill_seq;

drop sequence if exists prefered_language_seq;

drop sequence if exists profession_seq;

drop sequence if exists shoe_size_seq;

drop sequence if exists sport_skill_seq;

drop sequence if exists translation_seq;

drop sequence if exists user_seq;

drop sequence if exists user_language_skill_seq;

drop sequence if exists user_login_seq;

drop sequence if exists volunteer_seq;

