drop database spring_common_auth;
create database spring_common_auth;
use spring_common_auth;

create table if not exists admin_role
(
    id            bigint auto_increment comment 'pk'
    primary key,
    created_date  timestamp default CURRENT_TIMESTAMP not null,
    modified_data timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    description   varchar(255)                        null,
    role_name     varchar(255)                        null,
    role_type     varchar(255)                        null
    );

create table if not exists resource_api
(
    id                bigint auto_increment
    primary key,
    description       varchar(255) null,
    http_method       varchar(255) null,
    http_url          varchar(255) null,
    resource_category varchar(255) null,
    resource_name     varchar(255) null,
    resource_type     varchar(255) null
    );

create table if not exists admin_role_resource_api_link
(
    id              bigint auto_increment
    primary key,
    admin_role_id   bigint null,
    resource_api_id bigint null,
    constraint FKmegha8wmv5q5qvvtl0yjhu5xt
    foreign key (admin_role_id) references admin_role (id),
    constraint FKnipr9ce3m2lmyh2a0ojbr67gd
    foreign key (resource_api_id) references resource_api (id)
    );

create table if not exists user
(
    user_type           varchar(31)                         not null,
    id                  bigint auto_increment
    primary key,
    created_date        timestamp default CURRENT_TIMESTAMP not null,
    modified_data       timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    created_by          varchar(255)                        null,
    modified_by         varchar(255)                        null,
    active              tinyint                             null,
    blocked             tinyint                             null,
    email               varchar(255)                        null,
    last_login_datetime datetime                            null,
    last_login_ip       varchar(255)                        null,
    password            varchar(255)                        null,
    username            varchar(255)                        null,
    constraint UK_sb8bbouer5wak8vyiiy4pf2bx
    unique (username)
    );

create table if not exists admin_user
(
    user_id bigint not null
    primary key,
    constraint FKn2868jq6uao54f52dkcqo2xxi
    foreign key (user_id) references user (id)
    );

create table if not exists admin_user_role_link
(
    admin_user_role_link_id bigint auto_increment
    primary key,
    admin_role_id           bigint null,
    admin_user_id           bigint null,
    constraint FK28ucktwcvjyemmaufhid7xgxh
    foreign key (admin_user_id) references admin_user (user_id),
    constraint FKdm6ile2psy0l3yxum4kavr5wr
    foreign key (admin_role_id) references admin_role (id)
    );

create table if not exists member_user
(
    nickname varchar(255) null,
    user_id  bigint       not null
    primary key,
    constraint FK16qu8vcdeucv8rvwcs96iu5do
    foreign key (user_id) references user (id)
    );

