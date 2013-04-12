# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table owner (
  id                        varchar(255) not null,
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_owner primary key (id))
;

create table post (
  id                        varchar(255) not null,
  title                     varchar(255),
  content                   varchar(255),
  constraint pk_post primary key (id))
;

create sequence owner_seq;

create sequence post_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists owner;

drop table if exists post;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists owner_seq;

drop sequence if exists post_seq;

