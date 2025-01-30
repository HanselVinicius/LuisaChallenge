create table favorite_list
(
    id          bigint auto_increment primary key,
    description varchar(255) null,
    enabled     bit          not null,
    name        varchar(255) null,
    client_id   bigint       null,
    constraint fk_favorite_list_client
        foreign key (client_id) references client (id)
);
