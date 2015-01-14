# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table clothing_size (
  id                        bigint not null,
  size                      varchar(255),
  constraint pk_clothing_size primary key (id))
;

create table country (
  id                        bigint not null,
  iso2                      varchar(255),
  short_name                varchar(255),
  long_name                 varchar(255),
  iso3                      varchar(255),
  numcode                   varchar(255),
  un_member                 varchar(255),
  calling_code              varchar(255),
  cctld                     varchar(255),
  constraint pk_country primary key (id))
;

create table emergency_contact (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  phone_number              bigint,
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

create table interest (
  id                        bigint not null,
  interest                  varchar(255),
  translation_tid           bigint,
  constraint pk_interest primary key (id))
;

create table language_skill (
  id                        bigint not null,
  language_skill            varchar(255),
  translation_tid           bigint,
  constraint pk_language_skill primary key (id))
;

create table month (
  id                        bigint not null,
  month                     varchar(255),
  translation_tid           bigint,
  constraint pk_month primary key (id))
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
  username                  varchar(255),
  birthday_date             integer,
  birthdayMonth_id          bigint,
  birthday_year             integer,
  countryOfBirth_id         bigint,
  social_security_number    integer,
  place_of_residence        varchar(255),
  plz                       varchar(255),
  adress                    varchar(255),
  country_id                bigint,
  phone_number              bigint,
  mail                      varchar(255),
  adress_confirmed          boolean,
  identificationType_id     bigint,
  id_number                 varchar(255),
  date_of_issue             integer,
  monthOfIssue_id           bigint,
  year_of_issue             integer,
  issuing_authority         varchar(255),
  validUntilMonth_id        bigint,
  valid_until_year          integer,
  car_driving_license       boolean,
  other_driving_license     varchar(255),
  comment                   varchar(255),
  emergencyContact_id       bigint,
  jacketSize_id             bigint,
  trouserSize_id            bigint,
  shoeSize_id               bigint,
  profession_id             bigint,
  university                varchar(255),
  field_of_profession       varchar(255),
  professional_career       varchar(255),
  germanSkill_id            bigint,
  englishSkill_id           bigint,
  italianSkill_id           bigint,
  frenchSkill_id            bigint,
  spanishSkill_id           bigint,
  further_langues           varchar(255),
  interpreting_languages    varchar(255),
  translating_languages     varchar(255),
  msOfficeSkill_id          bigint,
  itNetworkSkill_id         bigint,
  contentManagementSkill_id bigint,
  graphicSkill_id           bigint,
  further_qualifications    varchar(255),
  events_participated       varchar(255),
  interested_icg2016        boolean,
  interested_icg2016prior_to_beginning boolean,
  icg2016comment            varchar(255),
  skiingSkill_id            bigint,
  snowboardSkill_id         bigint,
  crossCountrySkill_id      bigint,
  biathlonSkill_id          bigint,
  iceSkatingSkill_id        bigint,
  iceHockeySkill_id         bigint,
  interest1_id              bigint,
  interest2_id              bigint,
  interest3_id              bigint,
  availability_beginning    timestamp,
  availability_end          timestamp,
  availability_comment      varchar(255),
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
create sequence clothing_size_seq;

create sequence country_seq;

create sequence emergency_contact_seq;

create sequence event_seq;

create sequence gender_seq;

create sequence itmedia_skill_seq;

create sequence identification_type_seq;

create sequence interest_seq;

create sequence language_skill_seq;

create sequence month_seq;

create sequence profession_seq;

create sequence shoe_size_seq;

create sequence sport_skill_seq;

create sequence translation_seq;

create sequence user_seq;

create sequence user_login_seq;

create sequence volunteer_seq;

alter table gender add constraint fk_gender_translation_1 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_gender_translation_1 on gender (translation_tid);
alter table itmedia_skill add constraint fk_itmedia_skill_translation_2 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_itmedia_skill_translation_2 on itmedia_skill (translation_tid);
alter table identification_type add constraint fk_identification_type_transla_3 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_identification_type_transla_3 on identification_type (translation_tid);
alter table interest add constraint fk_interest_translation_4 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_interest_translation_4 on interest (translation_tid);
alter table language_skill add constraint fk_language_skill_translation_5 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_language_skill_translation_5 on language_skill (translation_tid);
alter table month add constraint fk_month_translation_6 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_month_translation_6 on month (translation_tid);
alter table profession add constraint fk_profession_translation_7 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_profession_translation_7 on profession (translation_tid);
alter table sport_skill add constraint fk_sport_skill_translation_8 foreign key (translation_tid) references translation (tid) on delete restrict on update restrict;
create index ix_sport_skill_translation_8 on sport_skill (translation_tid);
alter table user_login add constraint fk_user_login_volunteer_9 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;
create index ix_user_login_volunteer_9 on user_login (volunteer_id);
alter table volunteer add constraint fk_volunteer_sex_10 foreign key (sex_id) references gender (id) on delete restrict on update restrict;
create index ix_volunteer_sex_10 on volunteer (sex_id);
alter table volunteer add constraint fk_volunteer_user_11 foreign key (username) references user (username) on delete restrict on update restrict;
create index ix_volunteer_user_11 on volunteer (username);
alter table volunteer add constraint fk_volunteer_birthdayMonth_12 foreign key (birthdayMonth_id) references month (id) on delete restrict on update restrict;
create index ix_volunteer_birthdayMonth_12 on volunteer (birthdayMonth_id);
alter table volunteer add constraint fk_volunteer_countryOfBirth_13 foreign key (countryOfBirth_id) references country (id) on delete restrict on update restrict;
create index ix_volunteer_countryOfBirth_13 on volunteer (countryOfBirth_id);
alter table volunteer add constraint fk_volunteer_country_14 foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_volunteer_country_14 on volunteer (country_id);
alter table volunteer add constraint fk_volunteer_identificationTy_15 foreign key (identificationType_id) references identification_type (id) on delete restrict on update restrict;
create index ix_volunteer_identificationTy_15 on volunteer (identificationType_id);
alter table volunteer add constraint fk_volunteer_monthOfIssue_16 foreign key (monthOfIssue_id) references month (id) on delete restrict on update restrict;
create index ix_volunteer_monthOfIssue_16 on volunteer (monthOfIssue_id);
alter table volunteer add constraint fk_volunteer_validUntilMonth_17 foreign key (validUntilMonth_id) references month (id) on delete restrict on update restrict;
create index ix_volunteer_validUntilMonth_17 on volunteer (validUntilMonth_id);
alter table volunteer add constraint fk_volunteer_emergencyContact_18 foreign key (emergencyContact_id) references emergency_contact (id) on delete restrict on update restrict;
create index ix_volunteer_emergencyContact_18 on volunteer (emergencyContact_id);
alter table volunteer add constraint fk_volunteer_jacketSize_19 foreign key (jacketSize_id) references clothing_size (id) on delete restrict on update restrict;
create index ix_volunteer_jacketSize_19 on volunteer (jacketSize_id);
alter table volunteer add constraint fk_volunteer_trouserSize_20 foreign key (trouserSize_id) references clothing_size (id) on delete restrict on update restrict;
create index ix_volunteer_trouserSize_20 on volunteer (trouserSize_id);
alter table volunteer add constraint fk_volunteer_shoeSize_21 foreign key (shoeSize_id) references shoe_size (id) on delete restrict on update restrict;
create index ix_volunteer_shoeSize_21 on volunteer (shoeSize_id);
alter table volunteer add constraint fk_volunteer_profession_22 foreign key (profession_id) references profession (id) on delete restrict on update restrict;
create index ix_volunteer_profession_22 on volunteer (profession_id);
alter table volunteer add constraint fk_volunteer_germanSkill_23 foreign key (germanSkill_id) references language_skill (id) on delete restrict on update restrict;
create index ix_volunteer_germanSkill_23 on volunteer (germanSkill_id);
alter table volunteer add constraint fk_volunteer_englishSkill_24 foreign key (englishSkill_id) references language_skill (id) on delete restrict on update restrict;
create index ix_volunteer_englishSkill_24 on volunteer (englishSkill_id);
alter table volunteer add constraint fk_volunteer_italianSkill_25 foreign key (italianSkill_id) references language_skill (id) on delete restrict on update restrict;
create index ix_volunteer_italianSkill_25 on volunteer (italianSkill_id);
alter table volunteer add constraint fk_volunteer_frenchSkill_26 foreign key (frenchSkill_id) references language_skill (id) on delete restrict on update restrict;
create index ix_volunteer_frenchSkill_26 on volunteer (frenchSkill_id);
alter table volunteer add constraint fk_volunteer_spanishSkill_27 foreign key (spanishSkill_id) references language_skill (id) on delete restrict on update restrict;
create index ix_volunteer_spanishSkill_27 on volunteer (spanishSkill_id);
alter table volunteer add constraint fk_volunteer_msOfficeSkill_28 foreign key (msOfficeSkill_id) references itmedia_skill (id) on delete restrict on update restrict;
create index ix_volunteer_msOfficeSkill_28 on volunteer (msOfficeSkill_id);
alter table volunteer add constraint fk_volunteer_itNetworkSkill_29 foreign key (itNetworkSkill_id) references itmedia_skill (id) on delete restrict on update restrict;
create index ix_volunteer_itNetworkSkill_29 on volunteer (itNetworkSkill_id);
alter table volunteer add constraint fk_volunteer_contentManagemen_30 foreign key (contentManagementSkill_id) references itmedia_skill (id) on delete restrict on update restrict;
create index ix_volunteer_contentManagemen_30 on volunteer (contentManagementSkill_id);
alter table volunteer add constraint fk_volunteer_graphicSkill_31 foreign key (graphicSkill_id) references itmedia_skill (id) on delete restrict on update restrict;
create index ix_volunteer_graphicSkill_31 on volunteer (graphicSkill_id);
alter table volunteer add constraint fk_volunteer_skiingSkill_32 foreign key (skiingSkill_id) references sport_skill (id) on delete restrict on update restrict;
create index ix_volunteer_skiingSkill_32 on volunteer (skiingSkill_id);
alter table volunteer add constraint fk_volunteer_snowboardSkill_33 foreign key (snowboardSkill_id) references sport_skill (id) on delete restrict on update restrict;
create index ix_volunteer_snowboardSkill_33 on volunteer (snowboardSkill_id);
alter table volunteer add constraint fk_volunteer_crossCountrySkil_34 foreign key (crossCountrySkill_id) references sport_skill (id) on delete restrict on update restrict;
create index ix_volunteer_crossCountrySkil_34 on volunteer (crossCountrySkill_id);
alter table volunteer add constraint fk_volunteer_biathlonSkill_35 foreign key (biathlonSkill_id) references sport_skill (id) on delete restrict on update restrict;
create index ix_volunteer_biathlonSkill_35 on volunteer (biathlonSkill_id);
alter table volunteer add constraint fk_volunteer_iceskatingSkill_36 foreign key (iceSkatingSkill_id) references sport_skill (id) on delete restrict on update restrict;
create index ix_volunteer_iceskatingSkill_36 on volunteer (iceSkatingSkill_id);
alter table volunteer add constraint fk_volunteer_iceHockeySkill_37 foreign key (iceHockeySkill_id) references sport_skill (id) on delete restrict on update restrict;
create index ix_volunteer_iceHockeySkill_37 on volunteer (iceHockeySkill_id);
alter table volunteer add constraint fk_volunteer_interest1_38 foreign key (interest1_id) references interest (id) on delete restrict on update restrict;
create index ix_volunteer_interest1_38 on volunteer (interest1_id);
alter table volunteer add constraint fk_volunteer_interest2_39 foreign key (interest2_id) references interest (id) on delete restrict on update restrict;
create index ix_volunteer_interest2_39 on volunteer (interest2_id);
alter table volunteer add constraint fk_volunteer_interest3_40 foreign key (interest3_id) references interest (id) on delete restrict on update restrict;
create index ix_volunteer_interest3_40 on volunteer (interest3_id);



alter table volunteer_country add constraint fk_volunteer_country_voluntee_01 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;

alter table volunteer_country add constraint fk_volunteer_country_country_02 foreign key (country_id) references country (id) on delete restrict on update restrict;

alter table volunteer_event add constraint fk_volunteer_event_volunteer_01 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;

alter table volunteer_event add constraint fk_volunteer_event_event_02 foreign key (event_eventname) references event (eventname) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists clothing_size;

drop table if exists country;

drop table if exists emergency_contact;

drop table if exists event;

drop table if exists volunteer_event;

drop table if exists gender;

drop table if exists itmedia_skill;

drop table if exists identification_type;

drop table if exists interest;

drop table if exists language_skill;

drop table if exists month;

drop table if exists profession;

drop table if exists shoe_size;

drop table if exists sport_skill;

drop table if exists translation;

drop table if exists user;

drop table if exists user_login;

drop table if exists volunteer;

drop table if exists volunteer_country;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists clothing_size_seq;

drop sequence if exists country_seq;

drop sequence if exists emergency_contact_seq;

drop sequence if exists event_seq;

drop sequence if exists gender_seq;

drop sequence if exists itmedia_skill_seq;

drop sequence if exists identification_type_seq;

drop sequence if exists interest_seq;

drop sequence if exists language_skill_seq;

drop sequence if exists month_seq;

drop sequence if exists profession_seq;

drop sequence if exists shoe_size_seq;

drop sequence if exists sport_skill_seq;

drop sequence if exists translation_seq;

drop sequence if exists user_seq;

drop sequence if exists user_login_seq;

drop sequence if exists volunteer_seq;

