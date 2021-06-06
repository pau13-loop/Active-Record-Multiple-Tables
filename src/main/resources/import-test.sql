drop table if exists t_users;
drop table if exists t_items;
drop table if exists t_orders;

create table t_users (
    user_name varchar(255),
    user_prop integer,
    primary key (user_name)
);

create table t_items (
    item_name varchar(255),
    item_prop integer,
    item_type varchar(255),
    primary key (item_name)
);

create table t_orders (
    order_id bigint not null auto_increment,
    ord_user varchar(255),
    ord_item varchar(255),
    primary key (order_id),
    constraint `orden_item_fk` foreign key (ord_item) references t_items(item_name)
                      on delete set null
                      on update set null,
    constraint `orden_user_fk` foreign key (ord_user) references t_users(user_name)
                      on delete set null
                      on update set null
);

insert into t_users (user_name, user_prop) values
    ('Pau', 10),
    ('Lily', 15),
    ('Jackson', 20);

insert into t_items (item_name, item_prop, item_type) values
    ('Lolli Pop', 50, 'sweet'),
    ('Coca Cola', 60, 'drink'),
    ('Bread', 70, 'food');

insert into t_orders (order_id, ord_user, ord_item) values
    (1000, 'Pau', 'Lolli Pop'),
    (2000, 'Pau', 'Bread'),
    (3000, 'Lily', 'Coca Cola'),
    (4000, 'Jackson', 'Bread'),
    (5000, 'Jackson', 'Coca Cola');