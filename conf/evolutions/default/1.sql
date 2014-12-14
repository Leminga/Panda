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
  date_of_birth             datetime,
  constraint pk_additional_coach primary key (id))
;

create table additional_packet (
  packet_booked             tinyint(1) default 0,
  packet_paid               tinyint(1) default 0)
;

create table address (
  street                    varchar(255),
  housenumber               varchar(255),
  zip                       varchar(255),
  city                      varchar(255))
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
  date_of_birth             datetime,
  constraint pk_city_guest primary key (id))
;

create table city_rep_guest (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  date_of_birth             datetime,
  constraint pk_city_rep_guest primary key (id))
;

create table city_representative (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  date_of_birth             datetime,
  constraint pk_city_representative primary key (id))
;

create table coach (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  date_of_birth             datetime,
  constraint pk_coach primary key (id))
;

create table connectiontype (
  id                        bigint auto_increment not null,
  connection_type_tid       varchar(255),
  constraint pk_connectiontype primary key (id))
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
  date_of_birth             datetime,
  constraint pk_contractor primary key (id))
;

create table degree (
  id                        bigint auto_increment not null,
  degree_tid                bigint,
  constraint pk_degree primary key (id))
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

create table email_address (
  email_address             varchar(255))
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
  date_of_birth             datetime,
  constraint pk_head_of_delegation primary key (id))
;

create table icgguest (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  date_of_birth             datetime,
  constraint pk_icgguest primary key (id))
;

create table icgmember (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  date_of_birth             datetime,
  constraint pk_icgmember primary key (id))
;

create table icgmember_guest (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  date_of_birth             datetime,
  constraint pk_icgmember_guest primary key (id))
;

create table identification (
  identification_number     varchar(255),
  identification_type       integer,
  expiry_date               datetime,
  constraint ck_identification_identification_type check (identification_type in (0,1)))
;

create table identification_type)
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
  date_of_birth             datetime,
  constraint pk_locliaison_officer primary key (id))
;

create table locmember (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  date_of_birth             datetime,
  constraint pk_locmember primary key (id))
;

create table language (
  id                        bigint auto_increment not null,
  language_tid              bigint,
  constraint pk_language primary key (id))
;

create table languages (
  id                        bigint auto_increment not null,
  language_tid              bigint,
  constraint pk_languages primary key (id))
;

create table login_receiver (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
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
  date_of_birth             datetime,
  constraint pk_media primary key (id))
;

create table nationality (
  country_id                integer auto_increment not null,
  iso2                      varchar(255),
  short_name                varchar(255),
  long_name                 varchar(255),
  iso3                      varchar(255),
  numcode                   varchar(255),
  un_member                 varchar(255),
  calling_code              varchar(255),
  cctld                     varchar(255),
  constraint pk_nationality primary key (country_id))
;

create table organization (
  id                        bigint auto_increment not null,
  organization_type         varchar(255),
  organization_name         varchar(255),
  organization_size         integer,
  visible_for               tinyint(1) default 0,
  constraint pk_organization primary key (id))
;

create table phone (
  phone_number              integer,
  phone_type                integer,
  constraint ck_phone_phone_type check (phone_type in (0,1,2)))
;

create table preferred_communication_language (
  id                        bigint auto_increment not null,
  preferred_communication_language_tid bigint,
  constraint pk_preferred_communication_language primary key (id))
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

create table text_boxes (
  id                        bigint auto_increment not null,
  career                    varchar(255),
  other_qualification       varchar(255),
  constraint pk_text_boxes primary key (id))
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
  username                  varchar(255) not null,
  password                  varchar(255),
  creation_time             datetime,
  first_login               datetime,
  LastLogin                 datetime,
  auth_token                varchar(255),
  md5password               varchar(255),
  constraint pk_user_login primary key (username))
;

create table volunteer (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  date_of_birth             datetime,
  id_text_boxes             bigint,
  id_event_comment          bigint,
  social_security_number    varchar(255),
  volunteer_agreement       varbinary(255),
  constraint pk_volunteer primary key (id))
;

create table volunteer_simple (
  id                        bigint auto_increment not null,
  surname                   varchar(255),
  name                      varchar(255),
  date_of_birth             datetime,
  social_security_number    varchar(255),
  constraint pk_volunteer_simple primary key (id))
;


create table additional_coach_nationality (
  additional_coach_id            bigint not null,
  nationality_country_id         integer not null,
  constraint pk_additional_coach_nationality primary key (additional_coach_id, nationality_country_id))
;

create table additional_coach_degree (
  additional_coach_id            bigint not null,
  degree_id                      bigint not null,
  constraint pk_additional_coach_degree primary key (additional_coach_id, degree_id))
;

create table athlete_nationality (
  athlete_id                     bigint not null,
  nationality_country_id         integer not null,
  constraint pk_athlete_nationality primary key (athlete_id, nationality_country_id))
;

create table athlete_degree (
  athlete_id                     bigint not null,
  degree_id                      bigint not null,
  constraint pk_athlete_degree primary key (athlete_id, degree_id))
;

create table city_guest_nationality (
  city_guest_id                  bigint not null,
  nationality_country_id         integer not null,
  constraint pk_city_guest_nationality primary key (city_guest_id, nationality_country_id))
;

create table city_guest_degree (
  city_guest_id                  bigint not null,
  degree_id                      bigint not null,
  constraint pk_city_guest_degree primary key (city_guest_id, degree_id))
;

create table city_rep_guest_nationality (
  city_rep_guest_id              bigint not null,
  nationality_country_id         integer not null,
  constraint pk_city_rep_guest_nationality primary key (city_rep_guest_id, nationality_country_id))
;

create table city_rep_guest_degree (
  city_rep_guest_id              bigint not null,
  degree_id                      bigint not null,
  constraint pk_city_rep_guest_degree primary key (city_rep_guest_id, degree_id))
;

create table city_representative_nationality (
  city_representative_id         bigint not null,
  nationality_country_id         integer not null,
  constraint pk_city_representative_nationality primary key (city_representative_id, nationality_country_id))
;

create table city_representative_degree (
  city_representative_id         bigint not null,
  degree_id                      bigint not null,
  constraint pk_city_representative_degree primary key (city_representative_id, degree_id))
;

create table coach_nationality (
  coach_id                       bigint not null,
  nationality_country_id         integer not null,
  constraint pk_coach_nationality primary key (coach_id, nationality_country_id))
;

create table coach_degree (
  coach_id                       bigint not null,
  degree_id                      bigint not null,
  constraint pk_coach_degree primary key (coach_id, degree_id))
;

create table contractor_nationality (
  contractor_id                  bigint not null,
  nationality_country_id         integer not null,
  constraint pk_contractor_nationality primary key (contractor_id, nationality_country_id))
;

create table contractor_degree (
  contractor_id                  bigint not null,
  degree_id                      bigint not null,
  constraint pk_contractor_degree primary key (contractor_id, degree_id))
;

create table event_data_volunteer_nationality (
  event_data_volunteer_id        bigint not null,
  nationality_country_id         integer not null,
  constraint pk_event_data_volunteer_nationality primary key (event_data_volunteer_id, nationality_country_id))
;

create table event_data_volunteer_degree (
  event_data_volunteer_id        bigint not null,
  degree_id                      bigint not null,
  constraint pk_event_data_volunteer_degree primary key (event_data_volunteer_id, degree_id))
;

create table head_of_delegation_nationality (
  head_of_delegation_id          bigint not null,
  nationality_country_id         integer not null,
  constraint pk_head_of_delegation_nationality primary key (head_of_delegation_id, nationality_country_id))
;

create table head_of_delegation_degree (
  head_of_delegation_id          bigint not null,
  degree_id                      bigint not null,
  constraint pk_head_of_delegation_degree primary key (head_of_delegation_id, degree_id))
;

create table icgguest_nationality (
  icgguest_id                    bigint not null,
  nationality_country_id         integer not null,
  constraint pk_icgguest_nationality primary key (icgguest_id, nationality_country_id))
;

create table icgguest_degree (
  icgguest_id                    bigint not null,
  degree_id                      bigint not null,
  constraint pk_icgguest_degree primary key (icgguest_id, degree_id))
;

create table icgmember_nationality (
  icgmember_id                   bigint not null,
  nationality_country_id         integer not null,
  constraint pk_icgmember_nationality primary key (icgmember_id, nationality_country_id))
;

create table icgmember_degree (
  icgmember_id                   bigint not null,
  degree_id                      bigint not null,
  constraint pk_icgmember_degree primary key (icgmember_id, degree_id))
;

create table icgmember_guest_nationality (
  icgmember_guest_id             bigint not null,
  nationality_country_id         integer not null,
  constraint pk_icgmember_guest_nationality primary key (icgmember_guest_id, nationality_country_id))
;

create table icgmember_guest_degree (
  icgmember_guest_id             bigint not null,
  degree_id                      bigint not null,
  constraint pk_icgmember_guest_degree primary key (icgmember_guest_id, degree_id))
;

create table locliaison_officer_nationality (
  locliaison_officer_id          bigint not null,
  nationality_country_id         integer not null,
  constraint pk_locliaison_officer_nationality primary key (locliaison_officer_id, nationality_country_id))
;

create table locliaison_officer_degree (
  locliaison_officer_id          bigint not null,
  degree_id                      bigint not null,
  constraint pk_locliaison_officer_degree primary key (locliaison_officer_id, degree_id))
;

create table locmember_nationality (
  locmember_id                   bigint not null,
  nationality_country_id         integer not null,
  constraint pk_locmember_nationality primary key (locmember_id, nationality_country_id))
;

create table locmember_degree (
  locmember_id                   bigint not null,
  degree_id                      bigint not null,
  constraint pk_locmember_degree primary key (locmember_id, degree_id))
;

create table login_receiver_nationality (
  login_receiver_id              bigint not null,
  nationality_country_id         integer not null,
  constraint pk_login_receiver_nationality primary key (login_receiver_id, nationality_country_id))
;

create table login_receiver_degree (
  login_receiver_id              bigint not null,
  degree_id                      bigint not null,
  constraint pk_login_receiver_degree primary key (login_receiver_id, degree_id))
;

create table media_nationality (
  media_id                       bigint not null,
  nationality_country_id         integer not null,
  constraint pk_media_nationality primary key (media_id, nationality_country_id))
;

create table media_degree (
  media_id                       bigint not null,
  degree_id                      bigint not null,
  constraint pk_media_degree primary key (media_id, degree_id))
;

create table volunteer_nationality (
  volunteer_id                   bigint not null,
  nationality_country_id         integer not null,
  constraint pk_volunteer_nationality primary key (volunteer_id, nationality_country_id))
;

create table volunteer_degree (
  volunteer_id                   bigint not null,
  degree_id                      bigint not null,
  constraint pk_volunteer_degree primary key (volunteer_id, degree_id))
;

create table volunteer_simple_nationality (
  volunteer_simple_id            bigint not null,
  nationality_country_id         integer not null,
  constraint pk_volunteer_simple_nationality primary key (volunteer_simple_id, nationality_country_id))
;

create table volunteer_simple_degree (
  volunteer_simple_id            bigint not null,
  degree_id                      bigint not null,
  constraint pk_volunteer_simple_degree primary key (volunteer_simple_id, degree_id))
;



alter table additional_coach_nationality add constraint fk_additional_coach_nationality_additional_coach_01 foreign key (additional_coach_id) references additional_coach (id) on delete restrict on update restrict;

alter table additional_coach_nationality add constraint fk_additional_coach_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table additional_coach_degree add constraint fk_additional_coach_degree_additional_coach_01 foreign key (additional_coach_id) references additional_coach (id) on delete restrict on update restrict;

alter table additional_coach_degree add constraint fk_additional_coach_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table athlete_nationality add constraint fk_athlete_nationality_athlete_01 foreign key (athlete_id) references athlete (id) on delete restrict on update restrict;

alter table athlete_nationality add constraint fk_athlete_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table athlete_degree add constraint fk_athlete_degree_athlete_01 foreign key (athlete_id) references athlete (id) on delete restrict on update restrict;

alter table athlete_degree add constraint fk_athlete_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table city_guest_nationality add constraint fk_city_guest_nationality_city_guest_01 foreign key (city_guest_id) references city_guest (id) on delete restrict on update restrict;

alter table city_guest_nationality add constraint fk_city_guest_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table city_guest_degree add constraint fk_city_guest_degree_city_guest_01 foreign key (city_guest_id) references city_guest (id) on delete restrict on update restrict;

alter table city_guest_degree add constraint fk_city_guest_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table city_rep_guest_nationality add constraint fk_city_rep_guest_nationality_city_rep_guest_01 foreign key (city_rep_guest_id) references city_rep_guest (id) on delete restrict on update restrict;

alter table city_rep_guest_nationality add constraint fk_city_rep_guest_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table city_rep_guest_degree add constraint fk_city_rep_guest_degree_city_rep_guest_01 foreign key (city_rep_guest_id) references city_rep_guest (id) on delete restrict on update restrict;

alter table city_rep_guest_degree add constraint fk_city_rep_guest_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table city_representative_nationality add constraint fk_city_representative_nationality_city_representative_01 foreign key (city_representative_id) references city_representative (id) on delete restrict on update restrict;

alter table city_representative_nationality add constraint fk_city_representative_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table city_representative_degree add constraint fk_city_representative_degree_city_representative_01 foreign key (city_representative_id) references city_representative (id) on delete restrict on update restrict;

alter table city_representative_degree add constraint fk_city_representative_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table coach_nationality add constraint fk_coach_nationality_coach_01 foreign key (coach_id) references coach (id) on delete restrict on update restrict;

alter table coach_nationality add constraint fk_coach_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table coach_degree add constraint fk_coach_degree_coach_01 foreign key (coach_id) references coach (id) on delete restrict on update restrict;

alter table coach_degree add constraint fk_coach_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table contractor_nationality add constraint fk_contractor_nationality_contractor_01 foreign key (contractor_id) references contractor (id) on delete restrict on update restrict;

alter table contractor_nationality add constraint fk_contractor_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table contractor_degree add constraint fk_contractor_degree_contractor_01 foreign key (contractor_id) references contractor (id) on delete restrict on update restrict;

alter table contractor_degree add constraint fk_contractor_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table event_data_volunteer_nationality add constraint fk_event_data_volunteer_nationality_event_data_volunteer_01 foreign key (event_data_volunteer_id) references event_data_volunteer (id) on delete restrict on update restrict;

alter table event_data_volunteer_nationality add constraint fk_event_data_volunteer_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table event_data_volunteer_degree add constraint fk_event_data_volunteer_degree_event_data_volunteer_01 foreign key (event_data_volunteer_id) references event_data_volunteer (id) on delete restrict on update restrict;

alter table event_data_volunteer_degree add constraint fk_event_data_volunteer_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table head_of_delegation_nationality add constraint fk_head_of_delegation_nationality_head_of_delegation_01 foreign key (head_of_delegation_id) references head_of_delegation (id) on delete restrict on update restrict;

alter table head_of_delegation_nationality add constraint fk_head_of_delegation_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table head_of_delegation_degree add constraint fk_head_of_delegation_degree_head_of_delegation_01 foreign key (head_of_delegation_id) references head_of_delegation (id) on delete restrict on update restrict;

alter table head_of_delegation_degree add constraint fk_head_of_delegation_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table icgguest_nationality add constraint fk_icgguest_nationality_icgguest_01 foreign key (icgguest_id) references icgguest (id) on delete restrict on update restrict;

alter table icgguest_nationality add constraint fk_icgguest_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table icgguest_degree add constraint fk_icgguest_degree_icgguest_01 foreign key (icgguest_id) references icgguest (id) on delete restrict on update restrict;

alter table icgguest_degree add constraint fk_icgguest_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table icgmember_nationality add constraint fk_icgmember_nationality_icgmember_01 foreign key (icgmember_id) references icgmember (id) on delete restrict on update restrict;

alter table icgmember_nationality add constraint fk_icgmember_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table icgmember_degree add constraint fk_icgmember_degree_icgmember_01 foreign key (icgmember_id) references icgmember (id) on delete restrict on update restrict;

alter table icgmember_degree add constraint fk_icgmember_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table icgmember_guest_nationality add constraint fk_icgmember_guest_nationality_icgmember_guest_01 foreign key (icgmember_guest_id) references icgmember_guest (id) on delete restrict on update restrict;

alter table icgmember_guest_nationality add constraint fk_icgmember_guest_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table icgmember_guest_degree add constraint fk_icgmember_guest_degree_icgmember_guest_01 foreign key (icgmember_guest_id) references icgmember_guest (id) on delete restrict on update restrict;

alter table icgmember_guest_degree add constraint fk_icgmember_guest_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table locliaison_officer_nationality add constraint fk_locliaison_officer_nationality_locliaison_officer_01 foreign key (locliaison_officer_id) references locliaison_officer (id) on delete restrict on update restrict;

alter table locliaison_officer_nationality add constraint fk_locliaison_officer_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table locliaison_officer_degree add constraint fk_locliaison_officer_degree_locliaison_officer_01 foreign key (locliaison_officer_id) references locliaison_officer (id) on delete restrict on update restrict;

alter table locliaison_officer_degree add constraint fk_locliaison_officer_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table locmember_nationality add constraint fk_locmember_nationality_locmember_01 foreign key (locmember_id) references locmember (id) on delete restrict on update restrict;

alter table locmember_nationality add constraint fk_locmember_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table locmember_degree add constraint fk_locmember_degree_locmember_01 foreign key (locmember_id) references locmember (id) on delete restrict on update restrict;

alter table locmember_degree add constraint fk_locmember_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table login_receiver_nationality add constraint fk_login_receiver_nationality_login_receiver_01 foreign key (login_receiver_id) references login_receiver (id) on delete restrict on update restrict;

alter table login_receiver_nationality add constraint fk_login_receiver_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table login_receiver_degree add constraint fk_login_receiver_degree_login_receiver_01 foreign key (login_receiver_id) references login_receiver (id) on delete restrict on update restrict;

alter table login_receiver_degree add constraint fk_login_receiver_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table media_nationality add constraint fk_media_nationality_media_01 foreign key (media_id) references media (id) on delete restrict on update restrict;

alter table media_nationality add constraint fk_media_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table media_degree add constraint fk_media_degree_media_01 foreign key (media_id) references media (id) on delete restrict on update restrict;

alter table media_degree add constraint fk_media_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table volunteer_nationality add constraint fk_volunteer_nationality_volunteer_01 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;

alter table volunteer_nationality add constraint fk_volunteer_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table volunteer_degree add constraint fk_volunteer_degree_volunteer_01 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;

alter table volunteer_degree add constraint fk_volunteer_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table volunteer_simple_nationality add constraint fk_volunteer_simple_nationality_volunteer_simple_01 foreign key (volunteer_simple_id) references volunteer_simple (id) on delete restrict on update restrict;

alter table volunteer_simple_nationality add constraint fk_volunteer_simple_nationality_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table volunteer_simple_degree add constraint fk_volunteer_simple_degree_volunteer_simple_01 foreign key (volunteer_simple_id) references volunteer_simple (id) on delete restrict on update restrict;

alter table volunteer_simple_degree add constraint fk_volunteer_simple_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table actual_job;

drop table additional_coach;

drop table additional_coach_nationality;

drop table additional_coach_degree;

drop table additional_packet;

drop table address;

drop table arrival;

drop table athlete;

drop table athlete_nationality;

drop table athlete_degree;

drop table attachments;

drop table availability;

drop table city_guest;

drop table city_guest_nationality;

drop table city_guest_degree;

drop table city_rep_guest;

drop table city_rep_guest_nationality;

drop table city_rep_guest_degree;

drop table city_representative;

drop table city_representative_nationality;

drop table city_representative_degree;

drop table coach;

drop table coach_nationality;

drop table coach_degree;

drop table connectiontype;

drop table contact;

drop table contractor;

drop table contractor_nationality;

drop table contractor_degree;

drop table degree;

drop table departure;

drop table education_institute;

drop table educationlevel;

drop table email;

drop table email_address;

drop table emergency_contact;

drop table emergency_relation;

drop table event;

drop table event_comment;

drop table event_data_volunteer;

drop table event_data_volunteer_nationality;

drop table event_data_volunteer_degree;

drop table faculty;

drop table head_of_delegation;

drop table head_of_delegation_nationality;

drop table head_of_delegation_degree;

drop table icgguest;

drop table icgguest_nationality;

drop table icgguest_degree;

drop table icgmember;

drop table icgmember_nationality;

drop table icgmember_degree;

drop table icgmember_guest;

drop table icgmember_guest_nationality;

drop table icgmember_guest_degree;

drop table identification;

drop table identification_type;

drop table interview;

drop table it_knowledge;

drop table locliaison_officer;

drop table locliaison_officer_nationality;

drop table locliaison_officer_degree;

drop table locmember;

drop table locmember_nationality;

drop table locmember_degree;

drop table language;

drop table languages;

drop table login_receiver;

drop table login_receiver_nationality;

drop table login_receiver_degree;

drop table login_time;

drop table media;

drop table media_nationality;

drop table media_degree;

drop table nationality;

drop table organization;

drop table phone;

drop table preferred_communication_language;

drop table preferred_working_area;

drop table role;

drop table sex;

drop table sizes;

drop table sport;

drop table sport_interest;

drop table text_boxes;

drop table training;

drop table translation;

drop table user;

drop table user_login;

drop table volunteer;

drop table volunteer_nationality;

drop table volunteer_degree;

drop table volunteer_simple;

drop table volunteer_simple_nationality;

drop table volunteer_simple_degree;

SET FOREIGN_KEY_CHECKS=1;

