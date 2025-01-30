create table product
(
    id               bigint auto_increment primary key,
    description      TEXT  null,
    enabled          bit            not null,
    image            varchar(255)   null,
    price            decimal(38, 2) null,
    product_id       bigint         not null,
    title            varchar(255)   null,
    favorite_list_id bigint         null,
    constraint fk_product_favorite_list
        foreign key (favorite_list_id) references favorite_list (id)
);
