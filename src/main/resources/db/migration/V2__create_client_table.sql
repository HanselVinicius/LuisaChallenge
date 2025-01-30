create table client
(
    id      bigint auto_increment primary key,
    enabled bit          not null,
    name    varchar(255) null,
    auth_id bigint       null,
    constraint uq_client_auth_id
        unique (auth_id),
    constraint fk_client_auth
        foreign key (auth_id) references auth (id)
);
