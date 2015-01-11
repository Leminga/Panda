# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table additional_coach (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_additional_coach primary key (id))
;

create table additional_packet (
  packet_booked             boolean,
  packet_paid               boolean)
;

create table address (
  id                        bigint not null,
  connection_type_tid       bigint,
  connectionTypeTid         bigint,
  volunteer_id              bigint,
  street                    varchar(255),
  housenumber               varchar(255),
  zip                       varchar(255),
  city                      varchar(255),
  constraint uq_address_connection_type_tid unique (connection_type_tid),
  constraint pk_address primary key (id))
;

create table arrival (
  arrival_date              timestamp,
  arrival_place_tid         bigint,
  arrivalPlaceTid           bigint,
  arrival_flight_number     varchar(255),
  arrival_comment           varchar(255),
  constraint uq_arrival_arrival_place_tid unique (arrival_place_tid))
;

create table athlete (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_athlete primary key (id))
;

create table attachments (
  photo                     varbinary(255),
  copy_passport             varbinary(255),
  waiver                    varbinary(255))
;

create table availability (
  availability_start        timestamp,
  availability_end          timestamp,
  interest_in_assisting_before_event boolean)
;

create table city_guest (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_city_guest primary key (id))
;

create table city_rep_guest (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_city_rep_guest primary key (id))
;

create table city_representative (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_city_representative primary key (id))
;

create table coach (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_coach primary key (id))
;

create table contact (
  id                        bigint not null,
  connection_type_tid       bigint,
  connectionTypeTid         bigint,
  volunteer_id              bigint,
  constraint uq_contact_connection_type_tid unique (connection_type_tid),
  constraint pk_contact primary key (id))
;

create table contractor (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_contractor primary key (id))
;

create table current_job (
  current_jobid             bigint not null,
  currentJobTid             bigint,
  constraint pk_current_job primary key (current_jobid))
;

create table degree (
  id                        bigint not null,
  degree_tid                bigint,
  degreeTid                 bigint,
  constraint uq_degree_degree_tid unique (degree_tid),
  constraint pk_degree primary key (id))
;

create table departure (
  departure_date            timestamp,
  departure_place_tid       bigint,
  departurePlaceTid         bigint,
  departure_flight_number   varchar(255),
  departure_comment         varchar(255),
  constraint uq_departure_departure_place_tid unique (departure_place_tid))
;

create table education_institute (
  id                        bigint not null,
  education_institute_tid   bigint,
  educationInstituteTid     bigint,
  constraint uq_education_institute_education unique (education_institute_tid),
  constraint pk_education_institute primary key (id))
;

create table educationlevel (
  id                        bigint not null,
  educationlevel_tid        bigint,
  educationlevelTid         bigint,
  constraint uq_educationlevel_educationlevel unique (educationlevel_tid),
  constraint pk_educationlevel primary key (id))
;

create table email (
  id                        bigint not null,
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
  emergency_name            varchar(255),
  volunteer_id              bigint)
;

create table emergency_relation (
  id                        bigint not null,
  emergency_relation_tid    bigint,
  emergencyRelationTid      bigint,
  constraint uq_emergency_relation_emergency_ unique (emergency_relation_tid),
  constraint pk_emergency_relation primary key (id))
;

create table event (
  event_id                  bigint not null,
  eventname                 varchar(255),
  event_start               timestamp,
  event_end                 timestamp,
  eventDiscriptionTid       bigint,
  volunteer_open            boolean,
  dlo_open                  boolean,
  icg_member_open           boolean,
  clo_open                  boolean,
  loc_open                  boolean,
  media_open                boolean,
  constraint pk_event primary key (event_id))
;

create table event_comment (
  id                        bigint not null,
  comment                   varchar(255),
  constraint pk_event_comment primary key (id))
;

create table faculty (
  id                        bigint not null,
  faculty_tid               bigint,
  facultyTid                bigint,
  constraint uq_faculty_faculty_tid unique (faculty_tid),
  constraint pk_faculty primary key (id))
;

create table head_of_delegation (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_head_of_delegation primary key (id))
;

create table icgguest (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_icgguest primary key (id))
;

create table icgmember (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_icgmember primary key (id))
;

create table icgmember_guest (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_icgmember_guest primary key (id))
;

create table identification (
  identification_number     varchar(255),
  identification_type       integer,
  expiry_date               timestamp,
  volunteer_id              bigint,
  constraint ck_identification_identification_type check (identification_type in (0,1)))
;

create table identification_type (
  test                      varchar(255))
;

create table interview (
  id                        bigint not null,
  interview_date            timestamp,
  volunteer_id              bigint,
  interviewer_id            bigint,
  interview_comment         varchar(255),
  volunteerId               bigint,
  constraint uq_interview_volunteer_id unique (volunteer_id),
  constraint pk_interview primary key (id))
;

create table it_knowledge (
  id                        bigint not null,
  volunteer_id              bigint,
  itKnowledgeTid            bigint,
  constraint pk_it_knowledge primary key (id))
;

create table jacket_sizes (
  jacket_id                 bigint not null,
  jacket_size               varchar(255),
  constraint pk_jacket_sizes primary key (jacket_id))
;

create table locliaison_officer (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_locliaison_officer primary key (id))
;

create table locmember (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_locmember primary key (id))
;

create table language (
  id                        bigint not null,
  language_tid              bigint,
  volunteer_id              bigint,
  languageTid               bigint,
  constraint uq_language_language_tid unique (language_tid),
  constraint pk_language primary key (id))
;

create table languages_translation (
  id                        bigint not null,
  language_translation_tid  bigint,
  constraint pk_languages_translation primary key (id))
;

create table login_receiver (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  email                     varchar(255),
  group_t                   integer,
  constraint ck_login_receiver_group_t check (group_t in (0,1,2,3,4,5)),
  constraint pk_login_receiver primary key (id))
;

create table login_time (
  login                     timestamp)
;

create table media (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  constraint pk_media primary key (id))
;

create table nationality (
  country_id                integer not null,
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
  id                        bigint not null,
  organization_type         varchar(255),
  organization_name         varchar(255),
  organization_size         integer,
  visible_for               boolean,
  constraint pk_organization primary key (id))
;

create table permission (
  id                        bigint not null,
  constraint pk_permission primary key (id))
;

create table phone (
  id                        bigint not null,
  connection_type_tid       bigint,
  connectionTypeTid         bigint,
  volunteer_id              bigint,
  phone_number              integer,
  phone_type                integer,
  constraint ck_phone_phone_type check (phone_type in (0,1,2)),
  constraint uq_phone_connection_type_tid unique (connection_type_tid),
  constraint pk_phone primary key (id))
;

create table preferred_communication_language (
  id                        bigint not null,
  preferred_language_tid    bigint,
  preferredLanguageTid      bigint,
  constraint uq_preferred_communication_langu unique (preferred_language_tid),
  constraint pk_preferred_communication_langu primary key (id))
;

create table preferred_working_area (
  id                        bigint not null,
  preferred_area_tid        bigint,
  preferredAreaTid          bigint,
  constraint uq_preferred_working_area_prefer unique (preferred_area_tid),
  constraint pk_preferred_working_area primary key (id))
;

create table role (
  id                        bigint not null,
  role_tid                  bigint,
  roleTid                   bigint,
  visible_for               boolean,
  vid                       bigint,
  constraint uq_role_role_tid unique (role_tid),
  constraint uq_role_vid unique (vid),
  constraint pk_role primary key (id))
;

create table sex (
  id                        bigint not null,
  sexTid                    bigint,
  constraint pk_sex primary key (id))
;

create table shoe_sizes (
  shoe_id                   bigint not null,
  shoe_size                 integer,
  constraint pk_shoe_sizes primary key (shoe_id))
;

create table sport (
  id                        bigint not null,
  sport_tid                 bigint,
  sportTid                  bigint,
  constraint uq_sport_sport_tid unique (sport_tid),
  constraint pk_sport primary key (id))
;

create table sport_interest (
  id                        bigint not null,
  sport_interest_tid        bigint,
  sportInterestTid          bigint,
  constraint uq_sport_interest_sport_interest unique (sport_interest_tid),
  constraint pk_sport_interest primary key (id))
;

create table text_boxes (
  id                        bigint not null,
  career                    varchar(255),
  other_qualification       varchar(255),
  vid                       bigint,
  constraint uq_text_boxes_vid unique (vid),
  constraint pk_text_boxes primary key (id))
;

create table training (
  training_name             varchar(255) not null,
  trainingdate              timestamp,
  trainingquota             varchar(255),
  constraint pk_training primary key (training_name))
;

create table translation (
  tid                       bigint not null,
  german                    varchar(255),
  english                   varchar(255),
  constraint pk_translation primary key (tid))
;

create table trousers_sizes (
  trousers_id               bigint not null,
  trousers_size             varchar(255),
  constraint pk_trousers_sizes primary key (trousers_id))
;

create table user_login (
  username                  varchar(255) not null,
  password                  varchar(255),
  creation_time             timestamp,
  first_login               timestamp,
  last_login                timestamp,
  auth_token                varchar(255),
  chosen_language           varchar(255),
  volunteer_id              bigint,
  constraint pk_user_login primary key (username))
;

create table volunteer (
  id                        bigint not null,
  surname                   varchar(255),
  prename                   varchar(255),
  date_of_birth             timestamp,
  SexId                     bigint,
  JacketId                  bigint,
  TrousersId                bigint,
  ShoeId                    bigint,
  CurrentJobid              bigint,
  social_security_number    varchar(255),
  volunteer_agreement       varbinary(255),
  constraint pk_volunteer primary key (id))
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

create table volunteer_training (
  volunteer_id                   bigint not null,
  training_training_name         varchar(255) not null,
  constraint pk_volunteer_training primary key (volunteer_id, training_training_name))
;

create table volunteer_event (
  volunteer_id                   bigint not null,
  event_event_id                 bigint not null,
  constraint pk_volunteer_event primary key (volunteer_id, event_event_id))
;
create sequence additional_coach_seq;

create sequence address_seq;

create sequence athlete_seq;

create sequence city_guest_seq;

create sequence city_rep_guest_seq;

create sequence city_representative_seq;

create sequence coach_seq;

create sequence contact_seq;

create sequence contractor_seq;

create sequence current_job_seq;

create sequence degree_seq;

create sequence education_institute_seq;

create sequence educationlevel_seq;

create sequence email_seq;

create sequence emergency_relation_seq;

create sequence event_seq;

create sequence event_comment_seq;

create sequence faculty_seq;

create sequence head_of_delegation_seq;

create sequence icgguest_seq;

create sequence icgmember_seq;

create sequence icgmember_guest_seq;

create sequence interview_seq;

create sequence it_knowledge_seq;

create sequence jacket_sizes_seq;

create sequence locliaison_officer_seq;

create sequence locmember_seq;

create sequence language_seq;

create sequence languages_translation_seq;

create sequence login_receiver_seq;

create sequence media_seq;

create sequence nationality_seq;

create sequence organization_seq;

create sequence permission_seq;

create sequence phone_seq;

create sequence preferred_communication_language_seq;

create sequence preferred_working_area_seq;

create sequence role_seq;

create sequence sex_seq;

create sequence shoe_sizes_seq;

create sequence sport_seq;

create sequence sport_interest_seq;

create sequence text_boxes_seq;

create sequence training_seq;

create sequence translation_seq;

create sequence trousers_sizes_seq;

create sequence user_login_seq;

create sequence volunteer_seq;

alter table address add constraint fk_address_translation_1 foreign key (connectionTypeTid) references translation (tid) on delete restrict on update restrict;
create index ix_address_translation_1 on address (connectionTypeTid);
alter table address add constraint fk_address_volunteer_2 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;
create index ix_address_volunteer_2 on address (volunteer_id);
alter table arrival add constraint fk_arrival_translation_3 foreign key (arrivalPlaceTid) references translation (tid) on delete restrict on update restrict;
create index ix_arrival_translation_3 on arrival (arrivalPlaceTid);
alter table contact add constraint fk_contact_translation_4 foreign key (connectionTypeTid) references translation (tid) on delete restrict on update restrict;
create index ix_contact_translation_4 on contact (connectionTypeTid);
alter table contact add constraint fk_contact_volunteer_5 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;
create index ix_contact_volunteer_5 on contact (volunteer_id);
alter table current_job add constraint fk_current_job_translation_6 foreign key (currentJobTid) references translation (tid) on delete restrict on update restrict;
create index ix_current_job_translation_6 on current_job (currentJobTid);
alter table degree add constraint fk_degree_translation_7 foreign key (degreeTid) references translation (tid) on delete restrict on update restrict;
create index ix_degree_translation_7 on degree (degreeTid);
alter table departure add constraint fk_departure_translation_8 foreign key (departurePlaceTid) references translation (tid) on delete restrict on update restrict;
create index ix_departure_translation_8 on departure (departurePlaceTid);
alter table education_institute add constraint fk_education_institute_transla_9 foreign key (educationInstituteTid) references translation (tid) on delete restrict on update restrict;
create index ix_education_institute_transla_9 on education_institute (educationInstituteTid);
alter table educationlevel add constraint fk_educationlevel_translation_10 foreign key (educationlevelTid) references translation (tid) on delete restrict on update restrict;
create index ix_educationlevel_translation_10 on educationlevel (educationlevelTid);
alter table emergency_contact add constraint fk_emergency_contact_voluntee_11 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;
create index ix_emergency_contact_voluntee_11 on emergency_contact (volunteer_id);
alter table emergency_relation add constraint fk_emergency_relation_transla_12 foreign key (emergencyRelationTid) references translation (tid) on delete restrict on update restrict;
create index ix_emergency_relation_transla_12 on emergency_relation (emergencyRelationTid);
alter table event add constraint fk_event_translation_13 foreign key (eventDiscriptionTid) references translation (tid) on delete restrict on update restrict;
create index ix_event_translation_13 on event (eventDiscriptionTid);
alter table faculty add constraint fk_faculty_translation_14 foreign key (facultyTid) references translation (tid) on delete restrict on update restrict;
create index ix_faculty_translation_14 on faculty (facultyTid);
alter table identification add constraint fk_identification_volunteer_15 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;
create index ix_identification_volunteer_15 on identification (volunteer_id);
alter table interview add constraint fk_interview_volunteer_16 foreign key (volunteerId) references volunteer (id) on delete restrict on update restrict;
create index ix_interview_volunteer_16 on interview (volunteerId);
alter table it_knowledge add constraint fk_it_knowledge_volunteer_17 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;
create index ix_it_knowledge_volunteer_17 on it_knowledge (volunteer_id);
alter table it_knowledge add constraint fk_it_knowledge_translation_18 foreign key (itKnowledgeTid) references translation (tid) on delete restrict on update restrict;
create index ix_it_knowledge_translation_18 on it_knowledge (itKnowledgeTid);
alter table language add constraint fk_language_volunteer_19 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;
create index ix_language_volunteer_19 on language (volunteer_id);
alter table language add constraint fk_language_translation_20 foreign key (languageTid) references translation (tid) on delete restrict on update restrict;
create index ix_language_translation_20 on language (languageTid);
alter table phone add constraint fk_phone_translation_21 foreign key (connectionTypeTid) references translation (tid) on delete restrict on update restrict;
create index ix_phone_translation_21 on phone (connectionTypeTid);
alter table phone add constraint fk_phone_volunteer_22 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;
create index ix_phone_volunteer_22 on phone (volunteer_id);
alter table preferred_communication_language add constraint fk_preferred_communication_la_23 foreign key (preferredLanguageTid) references translation (tid) on delete restrict on update restrict;
create index ix_preferred_communication_la_23 on preferred_communication_language (preferredLanguageTid);
alter table preferred_working_area add constraint fk_preferred_working_area_tra_24 foreign key (preferredAreaTid) references translation (tid) on delete restrict on update restrict;
create index ix_preferred_working_area_tra_24 on preferred_working_area (preferredAreaTid);
alter table role add constraint fk_role_translation_25 foreign key (roleTid) references translation (tid) on delete restrict on update restrict;
create index ix_role_translation_25 on role (roleTid);
alter table role add constraint fk_role_volunteer_26 foreign key (Vid) references volunteer (id) on delete restrict on update restrict;
create index ix_role_volunteer_26 on role (Vid);
alter table sex add constraint fk_sex_translation_27 foreign key (sexTid) references translation (tid) on delete restrict on update restrict;
create index ix_sex_translation_27 on sex (sexTid);
alter table sport add constraint fk_sport_translation_28 foreign key (sportTid) references translation (tid) on delete restrict on update restrict;
create index ix_sport_translation_28 on sport (sportTid);
alter table sport_interest add constraint fk_sport_interest_translation_29 foreign key (sportInterestTid) references translation (tid) on delete restrict on update restrict;
create index ix_sport_interest_translation_29 on sport_interest (sportInterestTid);
alter table text_boxes add constraint fk_text_boxes_volunteer_30 foreign key (Vid) references volunteer (id) on delete restrict on update restrict;
create index ix_text_boxes_volunteer_30 on text_boxes (Vid);
alter table user_login add constraint fk_user_login_volunteer_31 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;
create index ix_user_login_volunteer_31 on user_login (volunteer_id);
alter table volunteer add constraint fk_volunteer_sex_32 foreign key (SexId) references sex (id) on delete restrict on update restrict;
create index ix_volunteer_sex_32 on volunteer (SexId);
alter table volunteer add constraint fk_volunteer_jacketId_33 foreign key (JacketId) references jacket_sizes (jacket_id) on delete restrict on update restrict;
create index ix_volunteer_jacketId_33 on volunteer (JacketId);
alter table volunteer add constraint fk_volunteer_trousersId_34 foreign key (TrousersId) references trousers_sizes (trousers_id) on delete restrict on update restrict;
create index ix_volunteer_trousersId_34 on volunteer (TrousersId);
alter table volunteer add constraint fk_volunteer_shoeId_35 foreign key (ShoeId) references shoe_sizes (shoe_id) on delete restrict on update restrict;
create index ix_volunteer_shoeId_35 on volunteer (ShoeId);
alter table volunteer add constraint fk_volunteer_currentJobid_36 foreign key (CurrentJobid) references current_job (current_jobid) on delete restrict on update restrict;
create index ix_volunteer_currentJobid_36 on volunteer (CurrentJobid);



alter table additional_coach_nationality add constraint fk_additional_coach_nationali_01 foreign key (additional_coach_id) references additional_coach (id) on delete restrict on update restrict;

alter table additional_coach_nationality add constraint fk_additional_coach_nationali_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table additional_coach_degree add constraint fk_additional_coach_degree_ad_01 foreign key (additional_coach_id) references additional_coach (id) on delete restrict on update restrict;

alter table additional_coach_degree add constraint fk_additional_coach_degree_de_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table athlete_nationality add constraint fk_athlete_nationality_athlet_01 foreign key (athlete_id) references athlete (id) on delete restrict on update restrict;

alter table athlete_nationality add constraint fk_athlete_nationality_nation_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table athlete_degree add constraint fk_athlete_degree_athlete_01 foreign key (athlete_id) references athlete (id) on delete restrict on update restrict;

alter table athlete_degree add constraint fk_athlete_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table city_guest_nationality add constraint fk_city_guest_nationality_cit_01 foreign key (city_guest_id) references city_guest (id) on delete restrict on update restrict;

alter table city_guest_nationality add constraint fk_city_guest_nationality_nat_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table city_guest_degree add constraint fk_city_guest_degree_city_gue_01 foreign key (city_guest_id) references city_guest (id) on delete restrict on update restrict;

alter table city_guest_degree add constraint fk_city_guest_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table city_rep_guest_nationality add constraint fk_city_rep_guest_nationality_01 foreign key (city_rep_guest_id) references city_rep_guest (id) on delete restrict on update restrict;

alter table city_rep_guest_nationality add constraint fk_city_rep_guest_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table city_rep_guest_degree add constraint fk_city_rep_guest_degree_city_01 foreign key (city_rep_guest_id) references city_rep_guest (id) on delete restrict on update restrict;

alter table city_rep_guest_degree add constraint fk_city_rep_guest_degree_degr_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table city_representative_nationality add constraint fk_city_representative_nation_01 foreign key (city_representative_id) references city_representative (id) on delete restrict on update restrict;

alter table city_representative_nationality add constraint fk_city_representative_nation_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table city_representative_degree add constraint fk_city_representative_degree_01 foreign key (city_representative_id) references city_representative (id) on delete restrict on update restrict;

alter table city_representative_degree add constraint fk_city_representative_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table coach_nationality add constraint fk_coach_nationality_coach_01 foreign key (coach_id) references coach (id) on delete restrict on update restrict;

alter table coach_nationality add constraint fk_coach_nationality_national_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table coach_degree add constraint fk_coach_degree_coach_01 foreign key (coach_id) references coach (id) on delete restrict on update restrict;

alter table coach_degree add constraint fk_coach_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table contractor_nationality add constraint fk_contractor_nationality_con_01 foreign key (contractor_id) references contractor (id) on delete restrict on update restrict;

alter table contractor_nationality add constraint fk_contractor_nationality_nat_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table contractor_degree add constraint fk_contractor_degree_contract_01 foreign key (contractor_id) references contractor (id) on delete restrict on update restrict;

alter table contractor_degree add constraint fk_contractor_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table head_of_delegation_nationality add constraint fk_head_of_delegation_nationa_01 foreign key (head_of_delegation_id) references head_of_delegation (id) on delete restrict on update restrict;

alter table head_of_delegation_nationality add constraint fk_head_of_delegation_nationa_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table head_of_delegation_degree add constraint fk_head_of_delegation_degree__01 foreign key (head_of_delegation_id) references head_of_delegation (id) on delete restrict on update restrict;

alter table head_of_delegation_degree add constraint fk_head_of_delegation_degree__02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table icgguest_nationality add constraint fk_icgguest_nationality_icggu_01 foreign key (icgguest_id) references icgguest (id) on delete restrict on update restrict;

alter table icgguest_nationality add constraint fk_icgguest_nationality_natio_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table icgguest_degree add constraint fk_icgguest_degree_icgguest_01 foreign key (icgguest_id) references icgguest (id) on delete restrict on update restrict;

alter table icgguest_degree add constraint fk_icgguest_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table icgmember_nationality add constraint fk_icgmember_nationality_icgm_01 foreign key (icgmember_id) references icgmember (id) on delete restrict on update restrict;

alter table icgmember_nationality add constraint fk_icgmember_nationality_nati_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table icgmember_degree add constraint fk_icgmember_degree_icgmember_01 foreign key (icgmember_id) references icgmember (id) on delete restrict on update restrict;

alter table icgmember_degree add constraint fk_icgmember_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table icgmember_guest_nationality add constraint fk_icgmember_guest_nationalit_01 foreign key (icgmember_guest_id) references icgmember_guest (id) on delete restrict on update restrict;

alter table icgmember_guest_nationality add constraint fk_icgmember_guest_nationalit_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table icgmember_guest_degree add constraint fk_icgmember_guest_degree_icg_01 foreign key (icgmember_guest_id) references icgmember_guest (id) on delete restrict on update restrict;

alter table icgmember_guest_degree add constraint fk_icgmember_guest_degree_deg_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table locliaison_officer_nationality add constraint fk_locliaison_officer_nationa_01 foreign key (locliaison_officer_id) references locliaison_officer (id) on delete restrict on update restrict;

alter table locliaison_officer_nationality add constraint fk_locliaison_officer_nationa_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table locliaison_officer_degree add constraint fk_locliaison_officer_degree__01 foreign key (locliaison_officer_id) references locliaison_officer (id) on delete restrict on update restrict;

alter table locliaison_officer_degree add constraint fk_locliaison_officer_degree__02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table locmember_nationality add constraint fk_locmember_nationality_locm_01 foreign key (locmember_id) references locmember (id) on delete restrict on update restrict;

alter table locmember_nationality add constraint fk_locmember_nationality_nati_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table locmember_degree add constraint fk_locmember_degree_locmember_01 foreign key (locmember_id) references locmember (id) on delete restrict on update restrict;

alter table locmember_degree add constraint fk_locmember_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table login_receiver_nationality add constraint fk_login_receiver_nationality_01 foreign key (login_receiver_id) references login_receiver (id) on delete restrict on update restrict;

alter table login_receiver_nationality add constraint fk_login_receiver_nationality_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table login_receiver_degree add constraint fk_login_receiver_degree_logi_01 foreign key (login_receiver_id) references login_receiver (id) on delete restrict on update restrict;

alter table login_receiver_degree add constraint fk_login_receiver_degree_degr_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table media_nationality add constraint fk_media_nationality_media_01 foreign key (media_id) references media (id) on delete restrict on update restrict;

alter table media_nationality add constraint fk_media_nationality_national_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table media_degree add constraint fk_media_degree_media_01 foreign key (media_id) references media (id) on delete restrict on update restrict;

alter table media_degree add constraint fk_media_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table volunteer_nationality add constraint fk_volunteer_nationality_volu_01 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;

alter table volunteer_nationality add constraint fk_volunteer_nationality_nati_02 foreign key (nationality_country_id) references nationality (country_id) on delete restrict on update restrict;

alter table volunteer_degree add constraint fk_volunteer_degree_volunteer_01 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;

alter table volunteer_degree add constraint fk_volunteer_degree_degree_02 foreign key (degree_id) references degree (id) on delete restrict on update restrict;

alter table volunteer_training add constraint fk_volunteer_training_volunte_01 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;

alter table volunteer_training add constraint fk_volunteer_training_trainin_02 foreign key (training_training_name) references training (training_name) on delete restrict on update restrict;

alter table volunteer_event add constraint fk_volunteer_event_volunteer_01 foreign key (volunteer_id) references volunteer (id) on delete restrict on update restrict;

alter table volunteer_event add constraint fk_volunteer_event_event_02 foreign key (event_event_id) references event (event_id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists additional_coach;

drop table if exists additional_coach_nationality;

drop table if exists additional_coach_degree;

drop table if exists additional_packet;

drop table if exists address;

drop table if exists arrival;

drop table if exists athlete;

drop table if exists athlete_nationality;

drop table if exists athlete_degree;

drop table if exists attachments;

drop table if exists availability;

drop table if exists city_guest;

drop table if exists city_guest_nationality;

drop table if exists city_guest_degree;

drop table if exists city_rep_guest;

drop table if exists city_rep_guest_nationality;

drop table if exists city_rep_guest_degree;

drop table if exists city_representative;

drop table if exists city_representative_nationality;

drop table if exists city_representative_degree;

drop table if exists coach;

drop table if exists coach_nationality;

drop table if exists coach_degree;

drop table if exists contact;

drop table if exists contractor;

drop table if exists contractor_nationality;

drop table if exists contractor_degree;

drop table if exists current_job;

drop table if exists degree;

drop table if exists departure;

drop table if exists education_institute;

drop table if exists educationlevel;

drop table if exists email;

drop table if exists email_address;

drop table if exists emergency_contact;

drop table if exists emergency_relation;

drop table if exists event;

drop table if exists event_comment;

drop table if exists faculty;

drop table if exists head_of_delegation;

drop table if exists head_of_delegation_nationality;

drop table if exists head_of_delegation_degree;

drop table if exists icgguest;

drop table if exists icgguest_nationality;

drop table if exists icgguest_degree;

drop table if exists icgmember;

drop table if exists icgmember_nationality;

drop table if exists icgmember_degree;

drop table if exists icgmember_guest;

drop table if exists icgmember_guest_nationality;

drop table if exists icgmember_guest_degree;

drop table if exists identification;

drop table if exists identification_type;

drop table if exists interview;

drop table if exists it_knowledge;

drop table if exists jacket_sizes;

drop table if exists locliaison_officer;

drop table if exists locliaison_officer_nationality;

drop table if exists locliaison_officer_degree;

drop table if exists locmember;

drop table if exists locmember_nationality;

drop table if exists locmember_degree;

drop table if exists language;

drop table if exists languages_translation;

drop table if exists login_receiver;

drop table if exists login_receiver_nationality;

drop table if exists login_receiver_degree;

drop table if exists login_time;

drop table if exists media;

drop table if exists media_nationality;

drop table if exists media_degree;

drop table if exists nationality;

drop table if exists organization;

drop table if exists permission;

drop table if exists phone;

drop table if exists preferred_communication_language;

drop table if exists preferred_working_area;

drop table if exists role;

drop table if exists sex;

drop table if exists shoe_sizes;

drop table if exists sport;

drop table if exists sport_interest;

drop table if exists text_boxes;

drop table if exists training;

drop table if exists translation;

drop table if exists trousers_sizes;

drop table if exists user_login;

drop table if exists volunteer;

drop table if exists volunteer_nationality;

drop table if exists volunteer_degree;

drop table if exists volunteer_training;

drop table if exists volunteer_event;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists additional_coach_seq;

drop sequence if exists address_seq;

drop sequence if exists athlete_seq;

drop sequence if exists city_guest_seq;

drop sequence if exists city_rep_guest_seq;

drop sequence if exists city_representative_seq;

drop sequence if exists coach_seq;

drop sequence if exists contact_seq;

drop sequence if exists contractor_seq;

drop sequence if exists current_job_seq;

drop sequence if exists degree_seq;

drop sequence if exists education_institute_seq;

drop sequence if exists educationlevel_seq;

drop sequence if exists email_seq;

drop sequence if exists emergency_relation_seq;

drop sequence if exists event_seq;

drop sequence if exists event_comment_seq;

drop sequence if exists faculty_seq;

drop sequence if exists head_of_delegation_seq;

drop sequence if exists icgguest_seq;

drop sequence if exists icgmember_seq;

drop sequence if exists icgmember_guest_seq;

drop sequence if exists interview_seq;

drop sequence if exists it_knowledge_seq;

drop sequence if exists jacket_sizes_seq;

drop sequence if exists locliaison_officer_seq;

drop sequence if exists locmember_seq;

drop sequence if exists language_seq;

drop sequence if exists languages_translation_seq;

drop sequence if exists login_receiver_seq;

drop sequence if exists media_seq;

drop sequence if exists nationality_seq;

drop sequence if exists organization_seq;

drop sequence if exists permission_seq;

drop sequence if exists phone_seq;

drop sequence if exists preferred_communication_language_seq;

drop sequence if exists preferred_working_area_seq;

drop sequence if exists role_seq;

drop sequence if exists sex_seq;

drop sequence if exists shoe_sizes_seq;

drop sequence if exists sport_seq;

drop sequence if exists sport_interest_seq;

drop sequence if exists text_boxes_seq;

drop sequence if exists training_seq;

drop sequence if exists translation_seq;

drop sequence if exists trousers_sizes_seq;

drop sequence if exists user_login_seq;

drop sequence if exists volunteer_seq;

