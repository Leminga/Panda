# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table volunteer (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_volunteer primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table volunteer;

SET FOREIGN_KEY_CHECKS=1;

