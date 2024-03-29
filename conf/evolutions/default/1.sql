# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table post (
  id                        varchar(255) not null,
  title                     varchar(255),
  content                   varchar(255),
  constraint pk_post primary key (id))
;

create sequence post_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists post;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists post_seq;

