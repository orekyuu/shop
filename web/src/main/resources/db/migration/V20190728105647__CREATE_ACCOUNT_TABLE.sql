create table accounts
(
	id varchar(128) not null,
	password varchar(256) not null,
	mail_address varchar(128) not null,
	constraint accounts_pk primary key (id)
);
