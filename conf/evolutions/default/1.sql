# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table owner (
  id                        varchar(255) not null,
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_owner primary key (id))
;

create sequence owner_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists owner;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists owner_seq;

