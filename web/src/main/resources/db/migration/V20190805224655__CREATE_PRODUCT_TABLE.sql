create table circles
(
	id int auto_increment primary key,
	name varchar(128) not null,
	registered_at datetime not null,
	account_id varchar(128) not null,
	constraint circles_account_id_fk foreign key (account_id) references accounts (id)
);

create table products
(
	id int auto_increment primary key,
	name varchar(256) not null,
	description text not null,
	circle_id int not null,
	release_date datetime not null,
	wholesale_price int not null,
	registered_at datetime not null,
	constraint products_circles_id_fk foreign key (circle_id) references circles (id)
);

create table product_images
(
	id varchar(128) not null,
	product_id int not null,
	created_at datetime not null,
	constraint product_images_pk primary key (id),
	constraint product_images_products_id_fk foreign key (product_id) references products (id)
);
