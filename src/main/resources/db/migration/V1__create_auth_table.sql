create table auth
(
    id          bigint auto_increment primary key,
    credentials varchar(255) null,
    enabled     bit          not null,
    principal   varchar(255) null,
    constraint uq_auth_principal
        unique (principal)
);
